package com.springboilerplate.springboilerplate.helper;

import com.springboilerplate.springboilerplate.model.PasswordResetToken;
import com.springboilerplate.springboilerplate.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SecurityHelper {
    public SecurityHelper() {
    }

    public void grantUserChangePasswordPrivilege(PasswordResetToken passwordResetToken){
        User user = passwordResetToken.getUser();
        Authentication auth = new UsernamePasswordAuthenticationToken(user, null,
                Arrays.asList(new SimpleGrantedAuthority("CHANGE_PASSWORD_PRIVILEGE")));
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
}
