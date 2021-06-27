package com.henrry.overflow.repositories;

import com.henrry.overflow.models.Answer;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository<T> extends BaseRepository<Answer> {
}
