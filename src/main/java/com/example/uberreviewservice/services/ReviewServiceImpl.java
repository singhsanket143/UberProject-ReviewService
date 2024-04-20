package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public Review createReview(Review review) {
        Review review1 = Review.builder().content(review.getContent()).rating(review.getRating()).build();
        return reviewRepository.save(review1);
    }

    @Override
    public Optional<Review> findReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> finalAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Review updateReview(Review review, Long id) {

        Optional<Review> review1 = reviewRepository.findById(id);

        review1.ifPresent(review2 -> {
            //as any of the fields might not get updated so will just keep the previous text
            review2.setRating(review.getRating() != null ? review.getRating() : review1.get().getRating());
            review2.setContent(review.getContent() != null ? review.getContent() : review1.get().getContent());
        });
        return reviewRepository.save(review1.get());
    }

    @Override
    public boolean deleteReviewById(Long id) {
        try {
            Optional<Review> review = reviewRepository.findById(id);
            if(review.isEmpty()) return false;
            reviewRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
