package com.spenkana.result;

import org.junit.jupiter.api.Test;

import static com.spenkana.result.HttpError.httpError;
import static org.junit.jupiter.api.Assertions.*;

public class WhenHttpErrorsAreCreated {

	@Test
	void errorIsGeneratedForValidCode() {
		for (int i = 200; i < 600; ++i) {
			Result<HttpError, SimpleError> result =
					httpError(i);
			assertTrue(result.succeeded);
			assertEquals(i, result.output.httpCode);
		}

	}

	@Test
	void noErrorIsGeneratedForInvalidCode() {
		for (int i = -1; i < 100; ++i) {
			assertTrue(httpError(i).failed);
		}
		for (int i = 600; i < 1000; ++i) {
			assertTrue(httpError(i).failed);
		}

		assertEquals("Not an HTTP status code: " + 1,
					 httpError(1).error.message());
	}

	@Test
	void returnsDefaultMessage() {
		int code = 346;
		assertEquals("HTTP Status Code returned: " + code,
					 httpError(code).output.msg);
	}

	@Test
	void returnsCustomMessage() {
		String msg = "Custom msg";
		assertEquals(msg, httpError(234, msg).output.msg);
	}
}
