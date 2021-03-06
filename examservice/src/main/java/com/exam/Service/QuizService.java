package com.exam.Service;

import com.exam.entity.exam.Quiz;

import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizzes();
    public Quiz getQUiz(Long quizId);
    public void deleteQuiz(Long quizId);
}
