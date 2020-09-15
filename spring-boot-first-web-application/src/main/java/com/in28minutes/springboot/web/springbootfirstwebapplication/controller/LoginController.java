package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	/*
	@RequestMapping("/login")
    @ResponseBody
	public String loginMessage() {
		return "Hello World Modified";
	}
	 */

    @RequestMapping("/login")
    public String loginMessage() {
        return "login";
    }

    // Step 05
    @RequestMapping("/getLogin")
    public String getLoginMessage(@RequestParam String name, ModelMap model) {
        model.put("modelName", name);
        System.out.println("name is " + name);
        return "login";
    }

    @ResponseBody
    @RequestMapping("/testResponseBody")
    public String response() {
        return "response body returned modified";
    }

}
