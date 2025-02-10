package com.github.travelmates.model;

import com.github.travelmates.enums.ActivityEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "pin_activities",
        indexes = {
                @Index(columnList = "pin_id")
        }
)
public class PinActivities {

    @EmbeddedId
    private PinActivitiesId id;

    @ManyToOne
    @MapsId("pinId")
    @JoinColumn(name = "pin_id")
    private Pin pin;

    @Enumerated(EnumType.STRING)
    @Column(name = "activity", insertable = false, updatable = false)
    private ActivityEnum activity;

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
