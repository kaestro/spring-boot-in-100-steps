package com.second.spring.web.springbootsecondwebapplication.service;

import org.springframework.stereotype.Component;

@Component
public class AutoLoginService {

    public boolean isValidUser(String userid, String password) {
        return userid.equalsIgnoreCase("in28minutes")
                && password.equalsIgnoreCase("dummy");
    }
}
