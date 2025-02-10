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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ProfileActivitiesId implements Serializable {

    @Column(name = "profile_id")
    private Long profileId;

    @Enumerated(EnumType.STRING)
    private ActivityEnum activity;
}
