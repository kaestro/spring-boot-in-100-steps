package com.second.spring.web.springbootsecondwebapplication.service;

public class LoginService {

    public boolean validateUser(String userid, String password) {
        // Let's assume that in28minutes, dummy is only combination available
        return userid.equalsIgnoreCase("in28minutes")
                && password.equalsIgnoreCase("dummy");
    }

}
