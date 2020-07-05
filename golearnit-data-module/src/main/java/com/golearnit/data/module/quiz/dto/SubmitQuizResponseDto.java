package com.golearnit.data.module.quiz.dto;

import lombok.Data;

@Data
public class SubmitQuizResponseDto {
    private int attempted;
    private Long timeTaken;
    private int noOfQuestions;
    private Long accuracy;
    private int correctAnswers;
}
