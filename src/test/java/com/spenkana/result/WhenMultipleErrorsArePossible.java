package com.spenkana.result;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WhenMultipleErrorsArePossible {

    @Test
    public void errorListStateIsAccessibleWithoutArithmetic(){
        ErrorList errors = new ErrorList();

        assertFalse(errors.occurred());

        errors.add("Some error");

        assertTrue(errors.occurred());
    }
}
