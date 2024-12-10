package com.bia.bitask_backend.entity;

import com.bia.bitask_backend.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "board")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(
            name = "BOARD_ID_GENERATOR",
            sequenceName = "BOARD_ID_GEN",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String name;
}
