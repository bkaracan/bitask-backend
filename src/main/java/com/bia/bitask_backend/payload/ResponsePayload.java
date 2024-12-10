package com.bia.bitask_backend.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponsePayload<T> {

  private Integer statusCode;
  private String description;
  private Boolean isSuccess;
  private String message;
  private T data;
  private Boolean showNotification;

  public ResponsePayload(
      Integer statusCode, String description, Boolean isSuccess, String message, T data) {
    this(statusCode, description, isSuccess, message, data, false);
  }

  public static <T> ResponsePayload<T> success(Integer statusCode, String description, T data) {
    return new ResponsePayload<>(statusCode, description, true, null, data, false);
  }

  public static <T> ResponsePayload<T> error(
      Integer statusCode, String description, String message) {
    return new ResponsePayload<>(statusCode, description, false, message, null, false);
  }

  public static <T> ResponsePayload<T> withNotification(
      Integer statusCode, String description, T data, Boolean showNotification) {
    return new ResponsePayload<>(statusCode, description, true, null, data, showNotification);
  }
}
