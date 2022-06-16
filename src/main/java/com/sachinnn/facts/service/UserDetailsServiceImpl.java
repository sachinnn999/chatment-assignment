package com.sachinnn.facts.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //user mapping integration
        User hardCodedUser = new User("test", "test", new ArrayList<>());
        if (!hardCodedUser.getUsername().equals(username)) {
            throw new UsernameNotFoundException("Incorrect Credentials.");
        }
        return hardCodedUser;
    }
}
