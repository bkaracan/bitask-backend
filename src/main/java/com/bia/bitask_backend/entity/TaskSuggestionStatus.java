package com.bia.bitask_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskSuggestionStatus implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(
      name = "TASK_SUGGESTION_STATUS_ID_GENERATOR",
      sequenceName = "TASK_SUGGESTION_STATUS_ID_GEN",
      allocationSize = 1)
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "TASK_SUGGESTION_STATUS_ID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(unique = true, nullable = false, length = 50)
  private String name;
}
