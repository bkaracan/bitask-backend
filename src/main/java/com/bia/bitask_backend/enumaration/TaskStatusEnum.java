package com.bia.bitask_backend.enumaration;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TaskStatusEnum {
  OPEN(1L, "Open"),
  IN_PROGRESS(2L, "In-progress"),
  TEST(3L, "Test"),
  READY_FOR_RELEASE(4L, "Ready for release"),
  DONE(5L, "Done"),
  CANCELLED(6L, "Cancelled");

  private final Long code;
  private final String name;

  public static TaskStatusEnum getEnumByCode(Long code) {
    return Arrays.stream(TaskStatusEnum.values())
        .filter(taskStatusEnum -> taskStatusEnum.code.equals(code))
        .findFirst()
        .orElse(null);
  }

  public static TaskStatusEnum getEnumByName(String name) {
    return Arrays.stream(TaskStatusEnum.values())
        .filter(taskStatusEnum -> taskStatusEnum.name.equals(name))
        .findFirst()
        .orElse(null);
  }
}
