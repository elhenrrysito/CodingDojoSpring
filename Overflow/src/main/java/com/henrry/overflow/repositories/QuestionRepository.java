package com.henrry.overflow.repositories;

import com.henrry.overflow.models.Question;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository<T> extends BaseRepository<Question>{

}
