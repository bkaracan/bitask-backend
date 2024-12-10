package com.bia.bitask_backend.enumaration;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum TaskSuggestionStatusEnum {
  PENDING(1L, "Pending"),
  APPROVED(2L, "Approved"),
  REJECTED(3L, "Rejected"),
  CANCELLED(4L, "Cancelled");

  private final Long code;
  private final String name;

  public static TaskSuggestionStatusEnum getEnumByCode(Long code) {
    return Arrays.stream(TaskSuggestionStatusEnum.values())
        .filter(taskSuggestionStatusEnum -> taskSuggestionStatusEnum.code.equals(code))
        .findFirst()
        .orElse(null);
  }

  public static TaskSuggestionStatusEnum getEnumByName(String name) {
    return Arrays.stream(TaskSuggestionStatusEnum.values())
        .filter(taskSuggestionStatusEnum -> taskSuggestionStatusEnum.name.equals(name))
        .findFirst()
        .orElse(null);
  }

  TaskSuggestionStatusEnum(Long code, String name) {
    this.code = code;
    this.name = name;
  }
}
