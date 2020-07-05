package com.golearnit.data.module.quiz.dto;


import lombok.Data;

import java.util.List;

@Data
public class GetQuizResponseDto {

    private Long quizId;
    private String quizName;
    private Long category;
    private String level;
    private List<Questions> questionsList;
    private Long stopWatch;
}
