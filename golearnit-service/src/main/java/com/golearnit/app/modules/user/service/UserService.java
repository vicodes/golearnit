package com.golearnit.app.modules.user.service;


import com.golearnit.data.module.user.dto.UserInterestDto;
import com.golearnit.data.module.user.entity.User;


public interface UserService {

    User getUserById(Integer id);
    UserInterestDto getUserInterest(String userId);
}
