package com.henrry.dojooverflow.services;

import com.henrry.dojooverflow.models.Answer;
import com.henrry.dojooverflow.repositories.AnswerRepository;

import org.springframework.stereotype.Service;

@Service
public class AnswerService extends BaseService<Answer> {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository baseRepository) {
        super(baseRepository);
        this.answerRepository = baseRepository;
    }
}
