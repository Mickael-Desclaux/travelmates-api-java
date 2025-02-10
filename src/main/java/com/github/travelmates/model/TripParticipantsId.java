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
public class TripParticipantsId implements Serializable {

    @Column(name = "trip_id")
    private Long tripId;

    @Column(name = "user_id")
    private Long userId;
}
