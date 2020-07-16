package com.golearnit.data.module.user.dao.impl;

import com.golearnit.data.module.base.dao.impl.BaseDaoImpl;
import com.golearnit.data.module.user.dao.UserDAO;
import com.golearnit.data.module.user.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDAO {

    @Override
    public User getUserById(String id) {
        EntityManager entityManager = getEntityManager();
        Query nativeQuery = entityManager.createNativeQuery("select * from user where user_id=:id",User.class);
        nativeQuery.setParameter("id",id);
        User result =  (User) nativeQuery.getSingleResult();
        entityManager.close();
        return result;
    }
}
