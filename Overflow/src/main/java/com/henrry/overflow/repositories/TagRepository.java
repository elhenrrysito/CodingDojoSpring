package com.henrry.overflow.repositories;

import com.henrry.overflow.models.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository<T> extends BaseRepository<Tag> {
    Tag findBySubjectContaining(String subject);
}
