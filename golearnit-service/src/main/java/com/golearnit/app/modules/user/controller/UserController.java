package com.golearnit.app.modules.user.controller;

import com.golearnit.app.modules.user.service.UserService;
import com.golearnit.data.common.builder.GenericResponseBuilder;
import com.golearnit.data.common.dto.GenericResponseDto;
import com.golearnit.data.module.user.dto.UserInterestDto;
import com.golearnit.util.common.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-api")
public class UserController {
    private static Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getInterest", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseDto> getUserInterest(@RequestParam String userId) {
        logger.info("received request for getInterest for userId:{}", userId);
        if(StringUtils.isNullOrEmpty(userId)){
            return GenericResponseBuilder.createBadRequestResponse("UserId missing in request");
        }
        UserInterestDto response = new UserInterestDto();
        try {
            response = userService.getUserInterest(userId);

            return GenericResponseBuilder.createSuccessResponse(response);
        } catch (Exception e) {
            logger.error("Error while processing getInterest request for userId:{} ", userId,e);
            return GenericResponseBuilder.createErrorResponse(response);

        }
    }
}
