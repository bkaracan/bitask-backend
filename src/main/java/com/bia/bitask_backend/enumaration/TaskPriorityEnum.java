package com.bia.bitask_backend.enumaration;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum TaskPriorityEnum {
  LOW(1L, "Low"),
  MEDIUM(2L, "Medium"),
  HIGH(3L, "High");

  private final Long code;
  private final String name;

  public static TaskPriorityEnum getEnumByCode(Long code) {
    return Arrays.stream(TaskPriorityEnum.values())
        .filter(taskPriorityEnum -> taskPriorityEnum.code.equals(code))
        .findFirst()
        .orElse(null);
  }

  public static TaskPriorityEnum getEnumByName(String name) {
    return Arrays.stream(TaskPriorityEnum.values())
        .filter(taskPriorityEnum -> taskPriorityEnum.name.equals(name))
        .findFirst()
        .orElse(null);
  }

  TaskPriorityEnum(Long code, String name) {
    this.code = code;
    this.name = name;
  }
}
