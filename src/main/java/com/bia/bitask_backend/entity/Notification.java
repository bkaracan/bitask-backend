package com.bia.bitask_backend.entity;

import com.bia.bitask_backend.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "notification")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notification extends BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(
            name = "NOTIFICATION_ID_GENERATOR",
            sequenceName = "NOTIFICATION_ID_GEN",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTIFICATION_ID_GENERATOR")
    @Column(unique = true, nullable = false)
    private Long id;

    @Lob
    @Column(nullable = false)
    private String message;

}
