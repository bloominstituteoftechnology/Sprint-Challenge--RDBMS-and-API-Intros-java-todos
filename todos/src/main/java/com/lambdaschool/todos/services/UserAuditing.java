package com.lambdaschool.todos.services;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

//for keeping track of who is logged in and for making the auditing
@Component
public class UserAuditing implements AuditorAware<String>
{

    @Override
    public Optional<String> getCurrentAuditor()
    {
        String uname;
        //object that get created when a user logged in
        Authentication authentication = SecurityContextHolder.getContext()
                                                             .getAuthentication();
        if (authentication != null)
        {
            uname = authentication.getName();
        } else
        {
            uname = "SYSTEM";
        }
        return Optional.of(uname);
    }

}