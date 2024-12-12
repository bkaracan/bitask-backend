package com.bia.bitask_backend.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import lombok.*;

@Entity
@Table(name = "task_status")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskStatus implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(
      name = "TASK_STATUS_ID_GENERATOR",
      sequenceName = "TASK_STATUS_ID_GEN",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASK_STATUS_ID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(unique = true, nullable = false, length = 50)
  private String name;

  @OneToMany(mappedBy = "status", fetch = FetchType.LAZY)
  private List<Task> tasks;

}
