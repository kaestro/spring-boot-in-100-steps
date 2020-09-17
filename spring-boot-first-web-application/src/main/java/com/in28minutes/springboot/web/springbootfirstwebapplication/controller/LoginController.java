package com.in28minutes.springboot.web.springbootfirstwebapplication.controller;

import com.in28minutes.springboot.web.springbootfirstwebapplication.service.AutoLoginService;
import com.in28minutes.springboot.web.springbootfirstwebapplication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.DocFlavor;

@Controller
public class LoginController {

	/*
	@RequestMapping("/login")
    @ResponseBody
	public String loginMessage() {
		return "Hello World Modified";
	}
	 */

    LoginService loginService = new LoginService();

    @Autowired
    AutoLoginService autoLoginService;

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

    @RequestMapping(value="/testForm", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        return "form";
    }

    @RequestMapping(value="/testForm", method = RequestMethod.POST)
    public String showWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        boolean isValidUser = loginService.validateUser(name, password);

        if (!isValidUser)
            return "form";

        model.put("welcomeName", name);
        model.put("password", password);
        return "welcome";
    }

    @RequestMapping(value="/testAuto", method = RequestMethod.GET)
    public String showAutoLoginPage(ModelMap model) {
        return "autoForm";
    }

    @RequestMapping(value="/testAuto", method = RequestMethod.POST)
    public String showAutoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        boolean isValidUser = autoLoginService.isValidUser(name, password);

        if (!isValidUser) {
            model.put("message", "Invalid Credentials");
            return "autoForm";
        }

        model.put("welcomeName", name);
        model.put("password", password);
        return "welcome";
    }

}
