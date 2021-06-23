package com.exam.Service.Impl;

import com.exam.Repository.QuestionRepository;
import com.exam.Service.QuestionService;
import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {


    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestion() {
        return new HashSet<>(this.questionRepository.findAll());

    }

    @Override
    public Question getQuestion(Long questionId) {
        return this.questionRepository.findById(questionId).get();

    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long questionId) {
        this.questionRepository.deleteById(questionId);
    }


}
