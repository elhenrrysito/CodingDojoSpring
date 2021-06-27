package com.henrry.overflow.services;

import com.henrry.overflow.models.Question;
import com.henrry.overflow.repositories.BaseRepository;
import com.henrry.overflow.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService extends BaseService<Question> {
    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        super(questionRepository);
        this.questionRepository = questionRepository;
    }
}
