package com.golearnit.data.module.quiz.dto;

import lombok.Data;

import java.util.List;

@Data
public class SubmitQuizRequestDto {
    private Long quizId;
    private List<Questions> questionsList;
    private Long timeTaken;
}
