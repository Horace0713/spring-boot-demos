package com.horace.web.web.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

/**
 * @author Horace
 * @date 2019-08-11 11:36
 */
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultWrapper {
    private final Status status;
    private final String errorCode;
    private final String message;
    private final Object data;

    public enum Status {
        SUCCESS,
        FAILD,
        BAD_REQUEST
    }
}
