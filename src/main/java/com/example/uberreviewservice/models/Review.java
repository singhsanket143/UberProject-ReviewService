package com.example.uberreviewservice.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;

@Entity
@Table(name = "bookingreview")
public class Review {

    @Id // this annotation makes the id property a primary key of our table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity means auto_increment
    Long id;

    @Column(nullable = false)
    String content;

    Double rating;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP) // this annotation tells spring about the formats of Date object to be stored i.e. Date / Time ? Timestamp
    @CreatedDate // this annotation tells spring that only handle it for object creation
    Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate  // this annotation tells spring that only handle it for object update
    Date updatedAt;
}

// new Review(content, rating);