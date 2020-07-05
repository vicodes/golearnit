package com.golearnit.data.module.quiz.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = false)
public class Questions {
    private Long questionId;
    private String question;
    private List<String> optionSet;
    private boolean attempted;
    private String answer;
    private String note;
}
