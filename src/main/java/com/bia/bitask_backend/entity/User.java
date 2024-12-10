package com.bia.bitask_backend.entity;

import com.bia.bitask_backend.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "user_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User extends BaseEntity implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(name = "USER_ID_GENERATOR", sequenceName = "USER_ID_GEN", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(name = "first_name", nullable = false, length = 100)
  private String firstName;

  @Column(name = "last_name", nullable = false, length = 100)
  private String lastName;

  @Column(unique = true, nullable = false, length = 100)
  private String email;

  @Column(name = "pp_url")
  private String profilePictureUrl;
}
