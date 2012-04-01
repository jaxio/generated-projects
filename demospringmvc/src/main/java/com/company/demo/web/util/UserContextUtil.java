package com.company.demo.web.util;

import java.util.List;
import java.util.Locale;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.company.demo.security.UserContext;

/**
 * Simple pass over allowing org.springframework.faces.mvc.JsfView to access 'userContext' from EL.
 */
@Component("userContext")
public class UserContextUtil {

    public String getUsername() {
        return UserContext.getUsername();
    }

    public boolean isAnonymousUser() {
        return "anonymousUser".equalsIgnoreCase(getUsername());
    }

    public Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

    public static List<String> getRoles() {
        return UserContext.getRoles();
    }
}