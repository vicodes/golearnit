package com.golearnit.app.modules.quiz.controller;


import com.golearnit.app.modules.quiz.service.QuizService;
import com.golearnit.data.module.quiz.dto.GetQuizResponseDto;
import com.golearnit.data.module.quiz.dto.SubmitQuizRequestDto;
import com.golearnit.data.module.quiz.dto.SubmitQuizResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @RequestMapping(value = "/getQuestion", method = RequestMethod.GET)
    public ResponseEntity<String> getQuestion() {
        return new ResponseEntity<String>("hello world", HttpStatus.OK);
    }

    @RequestMapping(value = "/getQuiz", method = RequestMethod.GET)
    public ResponseEntity<GetQuizResponseDto> getTest(@RequestParam Long quizId) {

        return new ResponseEntity<GetQuizResponseDto>(quizService.getQuizById(quizId), HttpStatus.OK);
    }

    @RequestMapping(value = "/submitQuiz", method = RequestMethod.POST)
    public ResponseEntity<SubmitQuizResponseDto> submitQuiz(@RequestBody SubmitQuizRequestDto quiz) {

        return new ResponseEntity<SubmitQuizResponseDto>(quizService.submitQuiz(quiz), HttpStatus.OK);
    }
}
