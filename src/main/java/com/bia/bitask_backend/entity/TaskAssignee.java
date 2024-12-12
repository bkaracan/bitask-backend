package com.bia.bitask_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_assignee")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskAssignee implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(
      name = "TASK_ASSIGNEE_ID_GENERATOR",
      sequenceName = "TASK_ASSIGNEE_ID_GEN",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASK_ASSIGNEE_ID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(name = "assigned_at", nullable = false)
  private LocalDateTime assignedAt;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "task_id", nullable = false)
  private Task task;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

}
