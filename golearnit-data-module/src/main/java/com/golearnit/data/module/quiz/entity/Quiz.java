package com.golearnit.data.module.quiz.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "quiz")
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quiz_id")
    private Long quizId;

    @Column(name = "quiz_name")
    private String quizName;

    @Column(name = "quiz_duration")
    private Long quizDuration;

    @Column(name = "quiz_level")
    private String quizLevel;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "quiz_reward")
    private int quizReward;

    @Column(name = "no_of_questions")
    private int noOfQuestions;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "answer_revealed")
    private boolean answerRevealed;

    @Column(name = "created_on")
    private Date createdOn;


}