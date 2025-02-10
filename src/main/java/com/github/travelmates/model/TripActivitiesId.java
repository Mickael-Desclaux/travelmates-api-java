package com.github.travelmates.model;

import com.github.travelmates.enums.ActivityEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class TripActivitiesId implements Serializable {

    @Column(name = "trip_id")
    private Long tripId;

    @Enumerated(EnumType.STRING)
    private ActivityEnum activity;
}
