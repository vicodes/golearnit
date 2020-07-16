package com.golearnit.data.module.user.dao;

import com.golearnit.data.module.base.dao.BaseDao;
import com.golearnit.data.module.user.entity.User;

public interface UserDAO extends BaseDao<User> {

    User getUserById(String id);
}
