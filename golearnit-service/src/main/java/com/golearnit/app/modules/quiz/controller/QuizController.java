package com.golearnit.app.modules.quiz.controller;


import com.golearnit.app.modules.quiz.service.QuizService;
import com.golearnit.data.common.builder.GenericResponseBuilder;
import com.golearnit.data.common.dto.GenericResponseDto;
import com.golearnit.data.module.quiz.dto.GetQuizResponseDto;
import com.golearnit.data.module.quiz.dto.SubmitQuizRequestDto;
import com.golearnit.data.module.quiz.dto.SubmitQuizResponseDto;
import com.golearnit.util.common.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;


@RestController
@RequestMapping("/quiz")
public class QuizController {
    private static Logger logger = LogManager.getLogger(QuizController.class);

    @Autowired
    QuizService quizService;

    @RequestMapping(value = "/getQuestion", method = RequestMethod.GET)
    public ResponseEntity<String> getQuestion() {
        return new ResponseEntity<String>("hello world", HttpStatus.OK);
    }

    @RequestMapping(value = "/getQuiz", method = RequestMethod.GET)
    public ResponseEntity<GenericResponseDto> getTest(@RequestParam String quizId) {
        logger.info("Received request for getQuiz for quizId:{}",quizId);
        if(StringUtils.isNullOrEmpty(quizId)){
            logger.info("quizId missing in request");
            return GenericResponseBuilder.createBadRequestResponse("QuizId missing in request");
        }
        GetQuizResponseDto getQuizResponseDto ;
        try{
            getQuizResponseDto = quizService.getQuizById(quizId);
            logger.info("Response fetched successfully for quizId:{}",quizId);
            return GenericResponseBuilder.createSuccessResponse(getQuizResponseDto);
        }catch (Exception e){
            logger.error("Error while processing request for quizId:{}",quizId);
            return GenericResponseBuilder.createErrorResponse(null);
        }
    }

    @RequestMapping(value = "/submitQuiz", method = RequestMethod.POST)
    public ResponseEntity<GenericResponseDto> submitQuiz(@RequestBody SubmitQuizRequestDto request) {
        logger.info("Received submitQuiz request for quizId:{}",request.getQuizId());
        if(Objects.isNull(request)){
            return GenericResponseBuilder.createBadRequestResponse("Bad Request");
        }
        SubmitQuizResponseDto submitQuizResponseDto;
        try{
            submitQuizResponseDto = quizService.submitQuiz(request);
            logger.info("Response fetched successfully for quizId:{}",request.getQuizId());
            return GenericResponseBuilder.createSuccessResponse(submitQuizResponseDto);

        }catch (Exception e){
            logger.error("Error while processing request for quizId:{}",request.getQuizId());
            return GenericResponseBuilder.createErrorResponse(null);
        }

    }
}
