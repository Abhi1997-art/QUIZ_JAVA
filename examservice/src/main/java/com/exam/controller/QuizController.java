package com.exam.controller;

import com.exam.Service.QuizService;
import com.exam.entity.exam.Category;
import com.exam.entity.exam.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    //Add category
    @PostMapping("/")
    public ResponseEntity<?> addQUiz(@RequestBody Quiz quiz){
        Quiz quiz1=this.quizService.addQuiz(quiz);
        return ResponseEntity.ok(quiz1);
    }

    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable("quizId") Long quizId){
        return this.quizService.getQUiz(quizId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllQuiz(){
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }

    //Update
    @PutMapping("/")
    public Quiz updateQuiz(@RequestBody Quiz quiz){
        return this.quizService.updateQuiz(quiz);
    }

    @DeleteMapping("/{quizId}")
    public void deleteCategory(@PathVariable("quizId") Long quizId){
        this.quizService.deleteQuiz(quizId);
    }
}
