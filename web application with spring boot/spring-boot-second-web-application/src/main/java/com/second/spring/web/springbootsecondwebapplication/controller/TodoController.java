package com.second.spring.web.springbootsecondwebapplication.controller;

import com.second.spring.web.springbootsecondwebapplication.service.AutoLoginService;
import com.second.spring.web.springbootsecondwebapplication.service.LoginService;
import com.second.spring.web.springbootsecondwebapplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("welcomeName")
public class TodoController {

    @Autowired
    TodoService service;

    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        String name = (String) model.get("welcomeName");
        System.out.println(name);
        model.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }

}
