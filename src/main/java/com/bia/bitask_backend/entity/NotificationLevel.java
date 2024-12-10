package com.bia.bitask_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "notification_level")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotificationLevel implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(
      name = "NOTIFICATION_LEVEL_ID_GENERATOR",
      sequenceName = "NOTIFICATION_LEVEL_ID_GEN",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFICATION_LEVEL_ID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(unique = true, nullable = false, length = 50)
  private String name;
}
