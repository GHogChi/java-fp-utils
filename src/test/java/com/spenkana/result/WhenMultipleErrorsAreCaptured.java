package com.spenkana.result;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhenMultipleErrorsAreCaptured {


    @Test
    public void errorsCanBeAddedToList(){
        ErrorList errorList = new ErrorList();
        assertEquals(0, errorList.errorCount());
        SimpleError error = new SimpleError("error");

        errorList.add(error);

        assertEquals(1, errorList.errorCount());
        assertEquals(error, errorList.data().get(0));
    }


    @Test
    public void multipleErrorMessagesAreCoalesced(){
        ErrorList errorList = new ErrorList();
        errorList.add(new SimpleError("Error 1"));
        errorList.add(new SimpleError("Error 2"));

        String message = errorList.message();

        assertEquals("Error 1, Error 2", message);
    }
}
