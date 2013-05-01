package com.jaxio.web.util;

import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.dao.OptimisticLockingFailureException;

@Named
@Singleton
public class ExceptionUtil {

    /**
     * Use it during development as an action to throw exceptions and thus verify that your
     * error handling code is correct.
     */
    public void throwRuntimeException() {
        throw new RuntimeException("Just testing from ExceptionUtil ...");
    }

    public void throwDataAccessException() {
        throw new OptimisticLockingFailureException("Just testing DataAccessException from ExceptionUtil ...");
    }

    public static boolean isCausedBy(Throwable e, Class<?> cause) {
        Throwable current = e;
        while (current != null) {
            if (cause.isAssignableFrom(current.getClass())) {
                return true;
            }
            current = current.getCause();
        }
        return false;
    }

}