package com.henrry.waterbnb.services;

import com.henrry.waterbnb.models.Review;
import com.henrry.waterbnb.repositories.BaseRepository;
import com.henrry.waterbnb.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends BaseService<Review> {
    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository baseRepository) {
        super(baseRepository);
        this.reviewRepository = baseRepository;
    }
}
