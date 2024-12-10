package com.bia.bitask_backend.enumaration;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum DepartmentEnum {
  BUSINESS_ANALYSIS(1L, "Business Analysis"),
  SYSTEM_ARCHITECTURE(2L, "System Architecture"),
  BACKEND_DEVELOPMENT(3L, "Backend Development"),
  FRONTEND_DEVELOPMENT(4L, "Frontend Development"),
  TEST_QA(5L, "Test-Q&A"),
  DEVOPS(6L, "Devops");

  private final Long code;
  private final String name;

  public static DepartmentEnum getEnumByCode(Long code) {
    return Arrays.stream(DepartmentEnum.values())
        .filter(departmentEnum -> departmentEnum.code.equals(code))
        .findFirst()
        .orElse(null);
  }

  public static DepartmentEnum getEnumByName(String name) {
    return Arrays.stream(DepartmentEnum.values())
        .filter(departmentEnum -> departmentEnum.name.equals(name))
        .findFirst()
        .orElse(null);
  }

  DepartmentEnum(Long code, String name) {
    this.code = code;
    this.name = name;
  }
}
