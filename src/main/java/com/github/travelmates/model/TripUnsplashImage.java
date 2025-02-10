package com.github.travelmates.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "trip_unsplash_image")
public class TripUnsplashImage {

    @EmbeddedId
    private TripUnsplashImageId id;

    @ManyToOne
    @MapsId("tripId")
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(name = "author_firstname", length = 50)
    private String authorFirstname;

    @Column(name = "author_lastname", length = 50)
    private String authorLastname;

    @Column(name = "author_profile_picture")
    private String authorProfilePicture;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
