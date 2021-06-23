package com.exam.Service;

import com.exam.entity.exam.Question;
import com.exam.entity.exam.Quiz;

import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);
    public Question updateQuestion(Question question);
    public Set<Question> getQuestion();
    public Question getQuestion(Long questionId);
    public Set<Question> getQuestionOfQuiz(Quiz quiz);
    public void deleteQuestion(Long questionId);
}
