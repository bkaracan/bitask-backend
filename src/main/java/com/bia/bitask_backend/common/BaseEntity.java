package com.bia.bitask_backend.common;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

    private String createdBy;
    private String createdAt;
    private String lastModifiedBy;
    private String lastModifiedAt;
}
