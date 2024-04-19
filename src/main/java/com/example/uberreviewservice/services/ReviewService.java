package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    public Optional<Review> findReviewById(Long id);

    public List<Review> finalAllReviews();

    public boolean deleteReviewById(Long id);

}
