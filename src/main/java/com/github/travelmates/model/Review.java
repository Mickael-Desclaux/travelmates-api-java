package com.github.travelmates.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "review", indexes = {
        @Index(columnList = "user_id"),
        @Index(columnList = "pin_id"),
        @Index(columnList = "media_id")
})
public class Review {

    @EmbeddedId
    private ReviewId id;

    @Column(name = "media_id")
    private Long mediaId;

    @ManyToOne
    @JoinColumn(name = "user_id", insertable = false, updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne
    @JoinColumn(name = "pin_id", insertable = false, updatable = false)
    private Pin pin;

    @ManyToOne
    @JoinColumn(name = "media_id", insertable = false, updatable = false)
    private Media media;

    @Column(nullable = false)
    private Integer rating;

    @Column(length = 500)
    private String comment;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
