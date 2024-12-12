package com.bia.bitask_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "task_priority")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskPriority implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(
      name = "TASK_PRIORITY_ID_GENERATOR",
      sequenceName = "TASK_PRIORITY_ID_GEN",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASK_PRIORITY_ID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(unique = true, nullable = false, length = 20)
  private String name;

  @OneToMany(mappedBy = "priority", fetch = FetchType.LAZY)
  private List<Task> tasks;
}
