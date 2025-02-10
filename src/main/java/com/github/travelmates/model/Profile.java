package com.github.travelmates.model;

import com.github.travelmates.enums.GenderEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "profile",
        indexes = {
                @Index(columnList = "user_id"),
                @Index(columnList = "media_id")
        }
)
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", referencedColumnName = "id", unique = true, nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @OneToOne(optional = false)
    @JoinColumn(name = "media_id", referencedColumnName = "id", unique = true, nullable = false)
    private Media media;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private GenderEnum gender;

    @Column(length = 50, nullable = false)
    private String firstname;

    @Column(length = 50, nullable = false)
    private String lastname;

    @Column(name = "birth_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate birthDate;

    @Column(length = 255, nullable = false)
    private String address;

    @Column(length = 1000)
    private String bio;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<ProfileLanguages> profileLanguages = new ArrayList<>();

    @OneToMany(mappedBy = "profile", cascade = CascadeType.ALL)
    private List<ProfileActivities> profileActivities = new ArrayList<>();

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
