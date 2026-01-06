package com.eduardo.todo_list.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "tb_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private boolean done;

    @Column(nullable = false)
    private Instant createdAt;

    @PrePersist
    public void markAsCreated() {
        this.createdAt = Instant.now();
    }

    public void markAsDone() {
        this.done = true;
    }

}
