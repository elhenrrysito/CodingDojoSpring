package com.henrry.overflow.services;

import com.henrry.overflow.models.Tag;
import com.henrry.overflow.repositories.BaseRepository;
import com.henrry.overflow.repositories.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService extends BaseService<Tag> {
    private final TagRepository tagRepository;

    public TagService( TagRepository tagRepository) {
        super(tagRepository);
        this.tagRepository = tagRepository;
    }

    public Tag findByName(String subject) {
        return tagRepository.findBySubjectContaining(subject);
    }
}
