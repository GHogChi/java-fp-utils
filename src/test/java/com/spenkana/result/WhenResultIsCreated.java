package com.spenkana.result;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WhenResultIsCreated {
    @Test
    public void successMethodSetsSuccess() {
        Result<Void> result = Result.success();

        assertTrue(result.succeeded);
        assertFalse(result.failed);
    }

    @Test
    public void successFunctionReturnsPayload() {
        Result<Integer> result = Result.successWith(17);

        assertEquals(17, result.output);
    }

    @Test
    public void failureReturnsErrorMessage() {
        Result<Void> result = Result.failureDueTo("Error message");

        assertEquals("Error message", result.getErrorMessage());
    }


    @Test
    public void failureReturnsFormattedErrorMessage(){
        Result<Void> result = Result.failureDueTo("%s %d", "hello", 19);

        assertEquals("hello 19", result.error.message());
    }

    @Test
    public void failureReturnsSimpleError() {
        Result<Void> result = Result.failureDueTo(new SimpleError("Error message"));

        assertTrue(result.error instanceof SimpleError);
        assertEquals("Error message", result.getErrorMessage());
    }

    @Test
    public void failureWithExceptionReturnsExceptionalError() {
        String msg = "Oops";
        Result<Void> result = Result.failureDueTo(new RuntimeException(msg));

        SafeError error = result.error;
        assertTrue(error instanceof ExceptionalError);
        assertTrue(((ExceptionalError)error).exception instanceof  RuntimeException);
        assertEquals(error.message(), msg);
        assertEquals(result.getErrorMessage(), msg);
    }
}
