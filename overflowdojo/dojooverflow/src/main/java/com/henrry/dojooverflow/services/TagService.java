package com.henrry.dojooverflow.services;

import com.henrry.dojooverflow.models.Tag;
import com.henrry.dojooverflow.repositories.TagRepository;

import org.springframework.stereotype.Service;

@Service
public class TagService extends BaseService<Tag> {
    private final TagRepository tagRepository;

    public TagService(TagRepository baseRepository) {
        super(baseRepository);
        this.tagRepository = baseRepository;
    }

    
    
}
