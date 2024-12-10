package com.bia.bitask_backend.entity;

import com.bia.bitask_backend.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task extends BaseEntity implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "TASK_ID_GENERATOR", sequenceName = "TASK_ID_GEN", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASK_ID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(nullable = false, length = 100)
  private String title;

  @Lob
  @Column(length = 1000)
  private String description;

  @Column(name = "task_code", unique = true, nullable = false)
  private String taskCode;

  @Column(name = "start_date")
  private LocalDateTime startDate;

  @Column(name = "expected_end_date")
  private LocalDateTime expectedEndDate;
}