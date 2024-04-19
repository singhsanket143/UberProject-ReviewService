package com.example.uberreviewservice.controllers;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.services.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    // Constructor to inject ReviewService dependency
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // Endpoint to get review by ID
    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        // Call service to find review by ID
        Optional<Review> review = reviewService.findReviewById(id);
        // Return ResponseEntity with review if found, otherwise return not found status
        return review.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint to get all reviews
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        // Call service to fetch all reviews
        List<Review> reviews = reviewService.finalAllReviews();
        // Return ResponseEntity with list of reviews
        return ResponseEntity.ok(reviews);
    }

    // Endpoint to delete review by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReviewById(@PathVariable Long id) {
        // Call service to delete review by ID
        boolean deleted = reviewService.deleteReviewById(id);
        // Return no content if review was deleted, otherwise return not found status
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
