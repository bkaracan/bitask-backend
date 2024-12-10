package com.bia.bitask_backend.enumaration.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ResponseEnum {

    OK(200,"OK", Boolean.TRUE),
    BAD_REQUEST(400,"BAD_REQUEST", Boolean.FALSE),
    UNAUTHORIZED(401,"UNAUTHORIZED", Boolean.FALSE),
    FORBIDDEN(403,"FORBIDDEN", Boolean.FALSE),
    NOT_FOUND(404,"NOT_FOUND", Boolean.FALSE),
    ERROR(1000,"ERROR", Boolean.FALSE),
    NOTIFICATION(1001,"NOTIFICATION", Boolean.FALSE),
    INFO(1002,"INFO", Boolean.TRUE),
    WARNING(100,"WARNING", Boolean.TRUE);

    private final Integer httpStatusCode;
    private final String description;
    private final Boolean isSuccess;
}
