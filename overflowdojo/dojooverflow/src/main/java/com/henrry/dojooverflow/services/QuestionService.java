package com.henrry.dojooverflow.services;

import com.henrry.dojooverflow.models.Question;
import com.henrry.dojooverflow.repositories.QuestionRepository;

import org.springframework.stereotype.Service;

@Service
public class QuestionService extends BaseService<Question> {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        super(questionRepository);
        this.questionRepository = questionRepository;
    }
    
}
