package com.github.travelmates.model;

import com.github.travelmates.enums.MessageReferenceTypeEnum;
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
        name = "message",
        indexes = {
                @Index(columnList = "user_sender_id"),
                @Index(columnList = "media_id")
        })
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_sender_id", nullable = false)
    private User user;

    @Column(name = "reference_id", nullable = false)
    private Integer referenceId;

    @Enumerated(EnumType.STRING)
    @Column(name = "reference_type", nullable = false)
    private MessageReferenceTypeEnum referenceType;

    @OneToOne()
    @JoinColumn(name = "media_id", referencedColumnName = "id", nullable = true)
    private Media media;

    @Column(length = 1000, nullable = false)
    private String text;

    @Column(name = "sent_at", nullable = false, updatable = false)
    private LocalDateTime sentAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        sentAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
