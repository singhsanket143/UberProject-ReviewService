package com.example.uberreviewservice;

import com.example.uberreviewservice.controllers.ReviewController;
import com.example.uberreviewservice.services.ReviewService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReviewControllerTest {

    @Mock
    private ReviewService reviewService; // Mocked ReviewService

    @InjectMocks
    private ReviewController reviewController; // Injecting mock ReviewService into ReviewController

    @Test
    void testDeleteReviewById_NotFound() {
        // Arrange
        long reviewId = 1L;
        // Mocking ReviewService's deleteReviewById method to return false
        when(reviewService.deleteReviewById(anyLong())).thenReturn(false);

        // Act
        // Invoking deleteReviewById method of the ReviewController
        ResponseEntity<Void> responseEntity = reviewController.deleteReviewById(reviewId);

        // Assert
        // Verifying that the HTTP status code returned is HttpStatus.NOT_FOUND
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
        // Verifying that ReviewService's deleteReviewById method was called once with the specified reviewId
        verify(reviewService, times(1)).deleteReviewById(reviewId);
    }

    @Test
    void testDeleteReviewById_Success() {
        // Arrange
        long reviewId = 1L;
        // Mocking ReviewService's deleteReviewById method to return true
        when(reviewService.deleteReviewById(anyLong())).thenReturn(true);

        // Act
        // Invoking deleteReviewById method of the ReviewController
        ResponseEntity<Void> responseEntity = reviewController.deleteReviewById(reviewId);

        // Assert
        // Verifying that the HTTP status code returned is HttpStatus.NO_CONTENT
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        // Verifying that ReviewService's deleteReviewById method was called once with the specified reviewId
        verify(reviewService, times(1)).deleteReviewById(reviewId);
    }
}
