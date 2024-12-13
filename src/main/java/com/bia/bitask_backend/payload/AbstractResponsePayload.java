package com.bia.bitask_backend.payload;

import com.bia.bitask_backend.enumaration.core.ResponseEnum;
import com.bia.bitask_backend.enumaration.core.MessageEnum;

public class AbstractResponsePayload {

  public AbstractResponsePayload() {
    // Default constructor
  }

  public ResponsePayload<Void> setResponse() {
    return getDefaultSuccessResponse();
  }

  public <T> ResponsePayload<T> setResponse(T data) {
    return setResponseData(ResponseEnum.OK, data);
  }

  public <T> ResponsePayload<T> setResponse(ResponseEnum responseEnum, T data) {
    return setResponseData(responseEnum, data);
  }

  public ResponsePayload<Void> setResponse(ResponseEnum responseEnum, String message) {
    return setResponseData(responseEnum, message);
  }

  public ResponsePayload<Void> setResponse(ResponseEnum responseEnum, MessageEnum message) {
    return setResponseData(responseEnum, message.getMessage());
  }

  public <T> ResponsePayload<T> setResponse(
          ResponseEnum responseEnum, MessageEnum message, T data) {
    return setResponseData(responseEnum, message.getMessage(), data);
  }

  private ResponsePayload<Void> setResponseData(ResponseEnum responseEnum, String message) {
    return new ResponsePayload<>(
            responseEnum.getHttpStatusCode(),
            responseEnum.getDescription(),
            responseEnum.getIsSuccess(),
            message,
            null
    );
  }

  private <T> ResponsePayload<T> setResponseData(ResponseEnum responseEnum, T data) {
    return new ResponsePayload<>(
            responseEnum.getHttpStatusCode(),
            responseEnum.getDescription(),
            responseEnum.getIsSuccess(),
            null,
            data
    );
  }

  private <T> ResponsePayload<T> setResponseData(
          ResponseEnum responseEnum, String message, T data) {
    return new ResponsePayload<>(
            responseEnum.getHttpStatusCode(),
            responseEnum.getDescription(),
            responseEnum.getIsSuccess(),
            message,
            data
    );
  }

  private ResponsePayload<Void> getDefaultSuccessResponse() {
    return new ResponsePayload<>(
            ResponseEnum.OK.getHttpStatusCode(),
            ResponseEnum.OK.getDescription(),
            ResponseEnum.OK.getIsSuccess(),
            null,
            null
    );
  }

  // Removed unused parameter and implemented meaningful logic for showNotification
  public <T> ResponsePayload<T> setResponse(
          ResponseEnum responseEnum, String message, T data, Boolean showNotification) {
    return new ResponsePayload<>(
            responseEnum.getHttpStatusCode(),
            responseEnum.getDescription(),
            responseEnum.getIsSuccess(),
            message,
            data,
            showNotification
    );
  }

  public ResponsePayload<Void> setResponse(
          ResponseEnum responseEnum, MessageEnum message, Boolean showNotification) {
    return new ResponsePayload<>(
            responseEnum.getHttpStatusCode(),
            responseEnum.getDescription(),
            responseEnum.getIsSuccess(),
            message.getMessage(),
            null,
            showNotification
    );
  }

  public ResponsePayload<Void> setResponse(
          ResponseEnum responseEnum, String message, Boolean showNotification) {
    return new ResponsePayload<>(
            responseEnum.getHttpStatusCode(),
            responseEnum.getDescription(),
            responseEnum.getIsSuccess(),
            message,
            null,
            showNotification
    );
  }
}
