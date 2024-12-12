package com.bia.bitask_backend.entity;

import com.bia.bitask_backend.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "task_suggestion")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskSuggestion extends BaseEntity implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(
      name = "TASK_SUGGEST_ID_GENERATOR",
      sequenceName = "TASK_SUGGEST_ID_GEN",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASK_SUGGEST_ID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(nullable = false, length = 100)
  private String title;

  @Lob
  @Column(columnDefinition = "TEXT", nullable = false)
  private String description;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="status_id", nullable=false)
  private TaskSuggestionStatus status;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="assigned_to")
  private User assignedTo;

}
