package com.in28minutes.springboot.web.springbootfirstwebapplication.service;

import org.springframework.stereotype.Component;

@Component
public class AutoLoginService {

    public boolean isValidUser(String userid, String password) {
        return userid.equalsIgnoreCase("auto")
                && password.equalsIgnoreCase("wired");
    }
}
