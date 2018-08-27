package com.spenkana.utils.result;

import com.spenkana.utils.HttpStatus;

/**
 * Wraps an HttpStatus.
 */
public class HttpError extends SafeError<HttpStatus> {
    private final String msg;
    private final HttpStatus status;

    public HttpError(String msg, HttpStatus status) {
        this.msg = msg;
        this.status = status;
    }

    @Override
    public String message() {
        return msg;
    }

    @Override
    public HttpStatus data() {
        return status;
    }
}
