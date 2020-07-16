package com.golearnit.data.module.content.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "subjects")
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Integer subjectId ;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "quiz_count")
    private Integer quizCount;

    @Column(name = "content_count")
    private Integer contentCount;

    @JsonIgnore
    @Column(name = "created_on")
    private Date createdOn;

    @JsonIgnore
    @Column(name = "modified_on")
    private Date modifiedOn;
}
