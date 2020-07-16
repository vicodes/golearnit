package com.golearnit.app.modules.quiz.service;

import com.golearnit.data.module.quiz.dto.GetQuizResponseDto;
import com.golearnit.data.module.quiz.dto.SubmitQuizRequestDto;
import com.golearnit.data.module.quiz.dto.SubmitQuizResponseDto;

public interface QuizService {
    GetQuizResponseDto getQuizById(String quizId);

    SubmitQuizResponseDto submitQuiz(SubmitQuizRequestDto quiz);
}
