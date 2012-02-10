package com.jaxio.demo.web.util;

import org.springframework.stereotype.Component;

/**
 * Use it during development to throw exceptions from your flows and thus verify that your 
 * error handling politic is correct.
 */
@Component
public class ExceptionUtil {

    public void throwRuntimeException() {
        throw new RuntimeException("Just testing from ExceptionUtil ...");
    }
}