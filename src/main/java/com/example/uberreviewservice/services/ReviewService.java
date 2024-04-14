package com.example.uberreviewservice.services;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import com.example.uberreviewservice.models.Review;
import com.example.uberreviewservice.repositories.BookingRepository;
import com.example.uberreviewservice.repositories.DriverRepository;
import com.example.uberreviewservice.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    private ReviewRepository reviewRepository;
    private final BookingRepository bookingRepository;
    private final DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository,
                         BookingRepository bookingRepository,
                         DriverRepository driverRepository) {
        this.reviewRepository = reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("*************");
//        Review r = Review.builder()
//                .content("Amazing ride quality")
//                .rating(4.0).build();
//        Booking b = Booking
//                    .builder()
//                    .review(r)
//                    .endTime(new Date())
//                    .build();
//
//
//        bookingRepository.save(b);
//
//        System.out.println(r);
//       // this code executes sql query
//        System.out.println(r.getId());
//        List<Review> reviews = reviewRepository.findAll();
//
//        for(Review review : reviews) {
//            System.out.println(r.getContent());
//        }
//        Optional<Booking> b = bookingRepository.findById(6L);
//        if(b.isPresent()) {
//            bookingRepository.delete(b.get());
//        }

//            Optional<Driver> driver = driverRepository.findById(1L);
//            if(driver.isPresent()) {
//                System.out.println(driver.get().getName());
//                List<Booking> b = driver.get().getBookings();
//
////                List<Booking> bookings = bookingRepository.findAllByDriverId(1L);
//                for(Booking booking : b) {
//                    System.out.println(booking.getId());
//                }
//            }
//            Optional<Booking> b = bookingRepository.findById(1L);

//        reviewRepository.deleteById(2L);
//
        Optional<Driver> d = driverRepository.hqlFindByIdAndLicense(1L, "DL121212");
        System.out.println(d.get().getName());
    }
}
