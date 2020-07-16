package com.golearnit.app.modules.quiz.service.impl;

import com.golearnit.app.modules.quiz.service.QuizService;
import com.golearnit.data.module.quiz.dao.QuizDAO;
import com.golearnit.data.module.quiz.dto.GetQuizResponseDto;
import com.golearnit.data.module.quiz.dto.Questions;
import com.golearnit.data.module.quiz.dto.SubmitQuizRequestDto;
import com.golearnit.data.module.quiz.dto.SubmitQuizResponseDto;
import com.golearnit.data.module.quiz.entity.Questionnaire;
import com.golearnit.data.module.quiz.entity.Quiz;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {
    private static Logger logger = LogManager.getLogger(QuizServiceImpl.class);

    @Autowired
    QuizDAO quizDAO;

    @Override
    public GetQuizResponseDto getQuizById(String quizId) {
        Quiz quiz = quizDAO.getQuizByQuizId(quizId);
        GetQuizResponseDto getQuizResponseDto = new GetQuizResponseDto();
        getQuizResponseDto.setQuizId(quiz.getQuizId());
        getQuizResponseDto.setQuizName(quiz.getQuizName());
        getQuizResponseDto.setStopWatch(quiz.getQuizDuration());
        getQuizResponseDto.setLevel(quiz.getQuizLevel());
        getQuizResponseDto.setCategory(quiz.getCategoryId());
        List<Questionnaire> quizQuestionsList = quizDAO.getQuestionnaireByQuizId(quizId);
        List<Questions> questions =  quizQuestionsList.stream().map(this::getQuestions).collect(Collectors.toList());
        getQuizResponseDto.setQuestionsList(questions);
        return  getQuizResponseDto;
    }

    @Override
    public SubmitQuizResponseDto submitQuiz(SubmitQuizRequestDto quiz) {
        SubmitQuizResponseDto submitQuizResponseDto = new SubmitQuizResponseDto();
        List<Questions> attemptedQuestions = quiz.getQuestionsList().stream().filter(Questions::isAttempted).collect(Collectors.toList());
        int attempted = attemptedQuestions.size();
        int correctAnswerCount = getCorrectAnswerCount(quiz.getQuizId(),attemptedQuestions);
        submitQuizResponseDto.setNoOfQuestions(quiz.getQuestionsList().size());
        submitQuizResponseDto.setAttempted(attempted);
        submitQuizResponseDto.setTimeTaken(quiz.getTimeTaken());
        submitQuizResponseDto.setCorrectAnswers(correctAnswerCount);
        submitQuizResponseDto.setAccuracy((long) (attempted/correctAnswerCount*100));
        return submitQuizResponseDto;
    }

    private int getCorrectAnswerCount(Long quizId, List<Questions> questionsList) {
        int count;
        List<Questionnaire> questionnaireList = quizDAO.getQuestionnaireByQuizId(String.valueOf(quizId));
        Map<Long, String> queAnsMap = new HashMap<>();
        questionnaireList.forEach(questionnaire -> {
            queAnsMap.put(questionnaire.getQuestionId(),questionnaire.getAnswer());
        });

        count = (int) questionsList.stream()
                .filter(questions -> queAnsMap.containsKey(questions.getQuestionId()))
                .filter(questions -> queAnsMap.get(questions.getQuestionId()).equalsIgnoreCase(questions.getAnswer())).count();
        return count;
    }

    private Questions getQuestions(Questionnaire questionnaire){
        return Questions.builder()
                .questionId(questionnaire.getQuestionId())
                .question(questionnaire.getQuestion())
                .optionSet(Arrays.asList(questionnaire.getOptionsSet().split(",")))
                .build();

    }
}
