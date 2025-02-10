package com.github.travelmates.model;

import com.github.travelmates.enums.ConditionGenderEnum;
import com.github.travelmates.enums.ConditionPhysicalEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        indexes = {
            @Index(columnList = "owner_id")
        },
        uniqueConstraints = @UniqueConstraint(columnNames = {"owner_id", "title"}))
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User owner;

    @Column(length = 255, nullable = false)
    private String destination;

    @Column(nullable = false)
    private LocalDate dateFrom;

    @Column(nullable = false)
    private LocalDate dateTo;

    @Column(length = 45, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String description;

    @Column(nullable = false)
    private Integer budgetMin;

    @Column(nullable = false)
    private Integer budgetMax;

    @Column(nullable = false)
    private Integer conditionAgeMin;

    @Column(nullable = false)
    private Integer conditionAgeMax;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConditionPhysicalEnum conditionPhysical;

    @Column(nullable = false)
    private Integer conditionUserLimit;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ConditionGenderEnum conditionGender;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripUnsplashImage> images;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripParticipants> participants;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripActivities> tripActivities;

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
