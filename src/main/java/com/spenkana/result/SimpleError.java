package com.spenkana.result;

import java.text.MessageFormat;

import static java.lang.String.format;

/**
 * A SafeError that contains only a message string.
 *
 * @see SafeError
 */
public class SimpleError extends SafeError<String> {
    private final String message;
    public static final SimpleError NOT_AN_ERROR = new SimpleError(NO_ERROR_MESSAGE);

    public SimpleError(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

    public String data() {
        return message();
    }

    public static SimpleError fromException(Exception e) {
        return new SimpleError(
                MessageFormat.format(
                        "{0}: {1}", e.getClass().getName(),
                        e.getLocalizedMessage())
        );
    }

    public SimpleError(String format, Object... args){
        this(format(format, args));
    }

}
