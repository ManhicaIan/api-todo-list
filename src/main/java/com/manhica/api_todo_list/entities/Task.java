package com.manhica.api_todo_list.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "task_tb")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;

    private LocalDateTime due_date;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    private LocalDateTime completed_at;

    @PrePersist
    protected void onCreate(){
        taskStatus = TaskStatus.PENDING;
    }
}
