package com.bia.bitask_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_assignment_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskAssignmentHistory implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(
      name = "TASK_HISTORY_ID_GENERATOR",
      sequenceName = "TASK_HISTORY_ID_GEN",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASK_HISTORY_ID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(name = "start_time",nullable = false)
  private LocalDateTime startTime;

  @Column(name = "end_time")
  private LocalDateTime endTime;
}
