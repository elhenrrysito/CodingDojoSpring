package com.henrry.dojooverflow.repositories;

import com.henrry.dojooverflow.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
    List<Tag> findAll();
    Tag findBySubjectContaining(String subject);
}
