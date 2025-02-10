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
public class ReviewId implements Serializable {

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "pin_id")
    private Long pinId;
}
