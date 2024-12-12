package com.bia.bitask_backend.entity;

import com.bia.bitask_backend.common.BaseEntity;
import jakarta.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import lombok.*;

@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment extends BaseEntity implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(
      name = "COMMENT_ID_GENERATOR",
      sequenceName = "COMMENT_ID_GEN",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COMMENT_ID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long id;

  @Lob
  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn(name = "task_id", nullable=false)
  private Task task;

}
