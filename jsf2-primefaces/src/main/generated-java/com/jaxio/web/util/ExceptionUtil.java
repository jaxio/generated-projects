package com.jaxio.web.util;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Use it during development to throw exceptions from your flows and thus verify that your
 * error handling politic is correct.
 */
@Named
@Singleton
public class ExceptionUtil {

    public void throwRuntimeException() {
        throw new RuntimeException("Just testing from ExceptionUtil ...");
    }
}