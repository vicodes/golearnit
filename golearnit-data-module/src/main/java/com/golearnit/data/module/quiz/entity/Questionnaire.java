package com.golearnit.data.module.quiz.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "questionnaire")
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Long questionId;

    @Column(name = "question")
    private String question;

    @Column(name = "options_set")
    private String optionsSet;

    @Column(name = "answer")
    private String answer;

    @Column(name = "level")
    private String level;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "quiz_id")
    private int quizId;

    @Column(name = "created_on")
    private Date createdOn;
}