package fr.jaxio.demo.web.util;

import java.util.List;
import java.util.Locale;

import javax.inject.Named;
import javax.inject.Singleton;

import org.springframework.context.i18n.LocaleContextHolder;

import fr.jaxio.demo.context.UserContext;

/**
 * Simple pass over allowing org.springframework.faces.mvc.JsfView to access 'userContext' from EL.
 */
@Named("userContext")
@Singleton
public class UserContextUtil {

    public String getUsername() {
        return UserContext.getUsername();
    }

    public boolean isAnonymousUser() {
        return "anonymousUser".equalsIgnoreCase(getUsername());
    }

    public boolean isLoggedIn() {
        return !"anonymousUser".equalsIgnoreCase(getUsername());
    }

    public Locale getLocale() {
        return LocaleContextHolder.getLocale();
    }

    public List<String> getRoles() {
        return UserContext.getRoles();
    }
}