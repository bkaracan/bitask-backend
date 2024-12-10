package com.bia.bitask_backend.enumaration;

import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotificationStatusEnum {
  NEW(1L, "New"),
  OPENED(2L, "Opened");

  private final Long code;
  private final String name;

  public static NotificationStatusEnum getEnumByCode(Long code) {
    return Arrays.stream(NotificationStatusEnum.values())
        .filter(notificationStatusEnum -> notificationStatusEnum.code.equals(code))
        .findFirst()
        .orElse(null);
  }

  public static NotificationStatusEnum getEnumByName(String name) {
    return Arrays.stream(NotificationStatusEnum.values())
        .filter(notificationStatusEnum -> notificationStatusEnum.name.equals(name))
        .findFirst()
        .orElse(null);
  }
}
