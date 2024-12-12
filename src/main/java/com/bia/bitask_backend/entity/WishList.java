package com.bia.bitask_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "wish_list")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WishList implements Serializable {

  @Serial private static final long serialVersionUID = 1L;

  @Id
  @SequenceGenerator(
      name = "WISHLIST_ID_GENERATOR",
      sequenceName = "WISHLIST_ID_GEN",
      allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "WISHLIST_ID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(nullable = false, length = 100)
  private String title;

  @Lob
  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  @OneToOne(fetch=FetchType.LAZY)
  @JoinColumn(name="user_id", unique=true, nullable=false)
  private User user;

}
