package com.golearnit.app.modules.quiz.service;

import com.golearnit.data.module.quiz.dto.GetQuizResponseDto;
import com.golearnit.data.module.quiz.dto.SubmitQuizRequestDto;
import com.golearnit.data.module.quiz.dto.SubmitQuizResponseDto;
import com.golearnit.data.module.quiz.entity.Quiz;

public interface QuizService {
    GetQuizResponseDto getQuizById(Long quizId);

    SubmitQuizResponseDto submitQuiz(SubmitQuizRequestDto quiz);
}
