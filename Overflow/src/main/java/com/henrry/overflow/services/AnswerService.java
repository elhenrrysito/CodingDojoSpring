package com.henrry.overflow.services;

import com.henrry.overflow.models.Answer;
import com.henrry.overflow.repositories.AnswerRepository;
import com.henrry.overflow.repositories.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerService extends BaseService<Answer> {
    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        super(answerRepository);
        this.answerRepository = answerRepository;
    }
}
