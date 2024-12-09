package com.bia.bitask_backend.dto;

import com.bia.bitask_backend.enumaration.MessageEnum;
import com.bia.bitask_backend.enumaration.ResponseEnum;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AbstractResponsePayload {

    protected <T> ResponsePayload<T> createResponse(ResponseEnum responseEnum) {
        return new ResponsePayload<>(responseEnum);
    }

    protected <T> ResponsePayload<T> createResponse(ResponseEnum responseEnum, String message) {
        return new ResponsePayload<>(responseEnum, message);
    }

    protected <T> ResponsePayload<T> createResponse(ResponseEnum responseEnum, String message, T data) {
        return new ResponsePayload<>(responseEnum, message, data);
    }

    protected <T> ResponsePayload<T> createResponse(ResponseEnum responseEnum, T data) {
        ResponsePayload<T> payload = new ResponsePayload<>(responseEnum);
        payload.setData(data);
        return payload;
    }

    public ResponsePayload<Void> setResponse() {
        return createResponse(ResponseEnum.OK);
    }

    public <T> ResponsePayload<T> setResponse(T data) {
        return createResponse(ResponseEnum.OK, data);
    }

    public <T> ResponsePayload<T> setResponse(ResponseEnum responseEnum, T data) {
        return createResponse(responseEnum, data);
    }

    public ResponsePayload<Void> setResponse(ResponseEnum responseEnum, String message) {
        return createResponse(responseEnum, message);
    }

    public ResponsePayload<Void> setResponse(ResponseEnum responseEnum, MessageEnum message) {
        return createResponse(responseEnum, message.getMessage());
    }

    public <T> ResponsePayload<T> setResponse(ResponseEnum responseEnum, MessageEnum message, T data) {
        return createResponse(responseEnum, message.getMessage(), data);
    }
}
