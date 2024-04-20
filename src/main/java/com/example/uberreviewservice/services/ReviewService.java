package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    public Review createReview(Review review);

    public Optional<Review> findReviewById(Long id);

    public List<Review> finalAllReviews();

    public Review updateReview(Review review, Long id);

    public boolean deleteReviewById(Long id);

}
