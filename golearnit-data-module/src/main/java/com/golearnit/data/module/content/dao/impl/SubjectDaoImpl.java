package com.golearnit.data.module.content.dao.impl;

import com.golearnit.data.module.base.dao.impl.BaseDaoImpl;
import com.golearnit.data.module.content.dao.SubjectsDAO;
import com.golearnit.data.module.content.entity.Subjects;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SubjectDaoImpl extends BaseDaoImpl<Subjects> implements SubjectsDAO {

    @Override
    public List<Subjects> getSubjectByIds(List<String> ids) {
        EntityManager entityManager = getEntityManager();
        Query query = entityManager.createNativeQuery("select * from subjects where subject_id in (:ids) ",Subjects.class);
        query.setParameter("ids", ids);
        List<Subjects> resultList = query.getResultList();
        entityManager.close();
        return resultList;
    }
}
