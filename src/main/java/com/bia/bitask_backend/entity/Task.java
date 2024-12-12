package com.bia.bitask_backend.entity;

import com.bia.bitask_backend.common.BaseEntity;
import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "task")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Task extends BaseEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(nullable = false, length = 100)
  private String title;

  @Lob private String description;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "status_id", nullable = false)
  private TaskStatus status;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "board_id", nullable = false)
  private Board board;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "priority_id", nullable = false)
  private TaskPriority priority;

  @Column(unique = true, nullable = false, length = 50)
  private String taskCode;

  private LocalDateTime startDate;

  private LocalDateTime expectedEndDate;

  @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
  private List<TaskAssignee> assignees;

  @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
  private List<TaskAssignmentHistory> assignmentHistories;

  @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
  private List<Comment> comments;

  @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
  private List<Notification> notifications;
}
