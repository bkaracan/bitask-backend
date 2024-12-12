package com.bia.bitask_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "department")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Department implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(
      name = "DEPARTMENT_ID_GENERATOR",
      sequenceName = "DEPARTMENT_ID_GEN",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTMENT_ID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(unique = true, nullable = false, length = 100)
  private String name;

  @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
  private List<User> users;

}
