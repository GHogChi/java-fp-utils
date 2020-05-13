package com.spenkana.result;

import java.io.Serializable;

/**
 * Base class for error information.
 * <p>Subclasses can provide arbitrary extractable information</p>
 * <p>Errors are serializable, but it can be a serious security breach to send stack traces and other sensitive
 * information over the wire: extract them and write to a secure log or message handler.</p>
 * @param <T> the type of extractable information. This can be used to wrap lower-level errors.
 */
public abstract class SafeError<T> implements Serializable {
    public static final String NO_ERROR_MESSAGE = "No error";
    public static final SafeError<Void> NO_ERROR = new SafeError() {
        @Override
        public String message() {
            return NO_ERROR_MESSAGE;
        }

        @Override
        public Object data() {
            return null;
        }
    };
    public abstract String message();
    public abstract T data();
    public int errorCount() { return 1;}
}
