package com.spenkana.utils;

import com.spenkana.utils.result.Result;
import com.spenkana.utils.result.SimpleError;

import java.util.HashMap;

import static com.spenkana.utils.result.Result.failure;

/**
 * Represents an HTTP return code.
 * TODO capture all of them!
 * TODO set up group codes 1..5; calc by division
 * @see <a href="https://en.wikipedia.org/wiki/List_of_HTTP_status_codes">List of HTTP status codes</a>
 */
public enum HttpStatus {
    SUCCESS(200);


    private static HashMap<Integer, HttpStatus> statusesByCode;
    public final int code;

    HttpStatus(int code) {
        this.code = code;
    }

    private static void register(HttpStatus status){
        if (statusesByCode == null){
            statusesByCode = new HashMap<Integer, HttpStatus>();
        }
    }

    public static Result<HttpStatus, SimpleError> forCode(int code){
        return (statusesByCode.containsKey(code))
            ? Result.success(statusesByCode.get(code))
            : failure("No HTTP status registered for code "+code);
    }
}
