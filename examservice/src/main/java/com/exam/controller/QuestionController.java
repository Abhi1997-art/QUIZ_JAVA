package com.exam.controller;


import com.exam.Service.QuestionService;
import com.exam.Service.QuizService;
import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @Autowired
    QuizService quizService;

    //Add category
    @PostMapping("/")
    public ResponseEntity<?> addQuestion(@RequestBody Question question){
        Question question1=this.questionService.addQuestion(question);
        return ResponseEntity.ok(question1);
    }

    @GetMapping("/{qId}")
    public Question getQuestion(@PathVariable("qId") Long qId){
        return this.questionService.getQuestion(qId);
    }

    @GetMapping("/quiz/{qId}")
    public ResponseEntity<?> getAllQuestion(@PathVariable("qId") Long qId){
//        Quiz quiz = new Quiz();
//        quiz.setId(qId);
//        Set<Question> questionsOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
//        return ResponseEntity.ok(questionsOfQuiz);

        Quiz quiz = this.quizService.getQUiz(qId);
        Set<Question> questions = quiz.getQuestions();
        List list = new ArrayList(questions);
        if(list.size() > Integer.parseInt(quiz.getNumberOfQuestions())){
            list=list.subList(0,Integer.parseInt(quiz.getNumberOfQuestions()+1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/quiz/all/{qId}")
    public ResponseEntity<?> getAllQuestionAdmin(@PathVariable("qId") Long qId){
        Quiz quiz = new Quiz();
        quiz.setId(qId);
        Set<Question> questionsOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
        return ResponseEntity.ok(questionsOfQuiz);
    }

    //Update
    @PutMapping("/")
    public Question updateQuiz(@RequestBody Question question){
        return this.questionService.updateQuestion(question);
    }

    @DeleteMapping("/{qid}")
    public void delete(@PathVariable("qid") Long qid){
        this.questionService.deleteQuestion(qid);
    }


}
