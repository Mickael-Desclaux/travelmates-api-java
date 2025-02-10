package com.github.travelmates.model;

import com.github.travelmates.enums.LanguageEnum;
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
public class ProfileLanguagesId implements Serializable {

    @Column(name = "profile_id")
    private Long profileId;

    @Enumerated(EnumType.STRING)
    private LanguageEnum language;
}
