package com.golearnit.data.module.user.dto;

import com.golearnit.data.module.content.entity.Subjects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInterestDto {

    private Long userId;
    private List<Subjects> subjectsList;
}
