package com.github.travelmates.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class PinMediasId implements Serializable {

    @Column(name = "pin_id")
    private Long pinId;

    @Column(name = "media_id")
    private Long mediaId;
}
