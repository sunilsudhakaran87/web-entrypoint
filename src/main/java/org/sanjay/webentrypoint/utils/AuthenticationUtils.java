package org.sanjay.webentrypoint.utils;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenticationUtils {
    public String getLoggedInUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
