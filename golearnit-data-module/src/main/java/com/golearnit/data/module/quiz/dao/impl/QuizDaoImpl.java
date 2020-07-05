package com.golearnit.data.module.quiz.dao.impl;

import com.golearnit.data.module.base.dao.impl.BaseDaoImpl;
import com.golearnit.data.module.quiz.dao.QuizDAO;
import com.golearnit.data.module.quiz.entity.Questionnaire;
import com.golearnit.data.module.quiz.entity.Quiz;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class QuizDaoImpl extends BaseDaoImpl<Quiz> implements QuizDAO {

    @Override
    public Quiz getQuizByQuizId(Long quizId) {
        EntityManager entityManager= getEntityManager();
        String query = "select * from quiz where quiz_id=:quizId";
        Query nativeQuery = entityManager.createNativeQuery(query, Quiz.class);
        nativeQuery.setParameter("quizId",quizId);
        Quiz quiz = (Quiz) nativeQuery.getSingleResult();
        entityManager.close();
        return quiz;
    }
    @Override
    public List<Questionnaire> getQuestionnaireByQuizId(Long quizId) {
        EntityManager entityManager= getEntityManager();
        String query = "select * from questionnaire where quiz_id=:quizId";
        Query nativeQuery = entityManager.createNativeQuery(query, Questionnaire.class);
        nativeQuery.setParameter("quizId",quizId);
        List<Questionnaire> questionnaireList =  nativeQuery.getResultList();
        entityManager.close();
        return questionnaireList;
    }
}
