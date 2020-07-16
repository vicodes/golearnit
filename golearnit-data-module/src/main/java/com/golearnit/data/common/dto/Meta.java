package com.golearnit.data.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Meta {

    private String message;
    private String status;
    private Integer responseCode;
}
