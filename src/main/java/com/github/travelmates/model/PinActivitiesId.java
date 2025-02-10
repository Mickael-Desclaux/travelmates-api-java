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
public class PinActivitiesId implements Serializable {

    @Column(name = "pin_id")
    private Long pinId;

    @Enumerated(EnumType.STRING)
    private ActivityEnum activity;
}
