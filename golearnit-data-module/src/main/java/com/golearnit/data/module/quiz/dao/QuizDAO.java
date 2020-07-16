package com.golearnit.data.module.quiz.dao;

import com.golearnit.data.module.base.dao.BaseDao;
import com.golearnit.data.module.quiz.entity.Questionnaire;
import com.golearnit.data.module.quiz.entity.Quiz;

import java.util.List;

public interface QuizDAO extends BaseDao<Quiz> {

    Quiz getQuizByQuizId(String quizId);

    List<Questionnaire> getQuestionnaireByQuizId(String quizId);
}
