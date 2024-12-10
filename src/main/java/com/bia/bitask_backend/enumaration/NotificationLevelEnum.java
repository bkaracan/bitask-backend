package com.bia.bitask_backend.enumaration;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum NotificationLevelEnum {
  INFO(1L, "Info"),
  WARNING(2L, "Warning"),
  ERROR(3L, "Error");

  private final Long code;
  private final String name;

  public static NotificationLevelEnum getEnumByCode(Long code) {
    return Arrays.stream(NotificationLevelEnum.values())
        .filter(notificationLevelEnum -> notificationLevelEnum.code.equals(code))
        .findFirst()
        .orElse(null);
  }

  public static NotificationLevelEnum getEnumByName(String name) {
    return Arrays.stream(NotificationLevelEnum.values())
        .filter(notificationLevelEnum -> notificationLevelEnum.name.equals(name))
        .findFirst()
        .orElse(null);
  }

  NotificationLevelEnum(Long code, String name) {
    this.code = code;
    this.name = name;
  }
}
