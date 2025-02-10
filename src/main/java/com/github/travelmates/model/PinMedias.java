package com.github.travelmates.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "pin_medias",
        indexes = {
                @Index(columnList = "pin_id"),
                @Index(columnList = "media_id")
        })
public class PinMedias {

    @EmbeddedId
    private PinMediasId id;

    @ManyToOne
    @JoinColumn(name = "pin_id", insertable = false, updatable = false)
    private Pin pin;

    @ManyToOne
    @JoinColumn(name = "media_id", insertable = false, updatable = false)
    private Media media;

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
