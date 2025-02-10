package com.github.travelmates.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class TripUnsplashImageId implements Serializable {

    @Column(name = "trip_id")
    private Long tripId;

    @Column(name = "url")
    private String url;
}