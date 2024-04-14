package com.example.uberreviewservice.repositories;

import com.example.uberreviewservice.models.Booking;
import com.example.uberreviewservice.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

    Optional<Driver> findByIdAndLicenseNumber(Long id, String licenseNumber);

    @Query(nativeQuery = true, value = "SELECT * FROM Driver WHERE id = :id AND license_number = :license") // RAW mysql query , error is thrown at runtime is query has issue
    Optional<Driver> rawFindByIdAndLicenseNumber(Long id, String license);

    @Query("From Driver as d where d.id = :id AND d.licenseNumber = :ln") // Hibernate query, error is thrown at compile time
    Optional<Driver> hqlFindByIdAndLicense(Long id, String ln);
}
