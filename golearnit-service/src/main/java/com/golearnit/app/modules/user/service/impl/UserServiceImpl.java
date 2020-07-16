package com.golearnit.app.modules.user.service.impl;

import com.golearnit.app.modules.user.service.UserService;
import com.golearnit.data.module.content.dao.SubjectsDAO;
import com.golearnit.data.module.content.entity.Subjects;
import com.golearnit.data.module.user.dao.UserDAO;
import com.golearnit.data.module.user.dto.UserInterestDto;
import com.golearnit.data.module.user.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    UserDAO userDAO;

    @Autowired
    SubjectsDAO subjectsDAO;

    public User getUserById(Integer id) {
        return null;
    }

    public UserInterestDto getUserInterest(String userId) {
        List<Subjects> subjectsList = new ArrayList<>();
        User user = userDAO.getUserById(userId);
        if (Objects.nonNull(user)) {
            subjectsList = subjectsDAO.getSubjectByIds(Arrays.asList(user.getInterestSet().split(",")));
            logger.info("{} interest found for userId:{}", subjectsList.size(), userId);
        } else {
            logger.info("User not found for userId:{}", userId);
        }

        return new UserInterestDto(user.getUserId(), subjectsList);
    }
}
