package com.example.uberreviewservice.controllers;

import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.services.ReviewServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private ReviewServiceImpl reviewService;

    //constructor injection
    public ReviewController(ReviewServiceImpl reviewService){
        this.reviewService = reviewService;
    }

    //create new review
    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        return new ResponseEntity(reviewService.createReview(review), HttpStatus.CREATED);
    }

    //get review by id
    @GetMapping("/{id}")
    public Optional<Review> findReviewById(@PathVariable Long id){
        Optional<Review> review = reviewService.findReviewById(id);
        return review;
    }

    //get list of all the reviews
    @GetMapping
    public ResponseEntity<List<Review>> findAllReviews(){
        List<Review> reviewList = reviewService.finalAllReviews();
        return ResponseEntity.status(HttpStatus.OK).body(reviewList);
    }

    //update the review
    @PutMapping("/update")
    public ResponseEntity<String> updateReview(@RequestBody(required = false) Review review, @RequestParam Long id ){
        return new ResponseEntity(reviewService.updateReview(review, id), HttpStatus.OK);
    }

    //delete review by id
    @DeleteMapping("/{id}")
    public boolean deleteReviewById(@PathVariable Long id){
        return reviewService.deleteReviewById(id);
    }
}
