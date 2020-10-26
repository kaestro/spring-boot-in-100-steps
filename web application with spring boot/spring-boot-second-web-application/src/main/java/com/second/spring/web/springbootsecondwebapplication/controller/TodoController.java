package com.second.spring.web.springbootsecondwebapplication.controller;

import com.second.spring.web.springbootsecondwebapplication.model.Todo;
import com.second.spring.web.springbootsecondwebapplication.service.AutoLoginService;
import com.second.spring.web.springbootsecondwebapplication.service.LoginService;
import com.second.spring.web.springbootsecondwebapplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"welcomeName", "name"})
public class TodoController {

    @Autowired
    TodoService service;

    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model) {
        String name = (String) model.get("welcomeName");
        model.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model) {
        return "todo";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String desc) {
        service.addTodo((String) model.get("welcomeName"), desc, new Date(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value="/add-todo-commandBean", method = RequestMethod.GET)
    public String showAddTodoCommandBeanPage(ModelMap model) {
        model.addAttribute("todo", new Todo(0, (String) model.get("welcomeName"), "Default Desc", new Date(), false));
        return "todo hibernate validator";
    }
    @RequestMapping(value="/add-todo-commandBean", method = RequestMethod.POST)
    public String addTodoCommandBean(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo hibernate validator";
        }

        service.addTodo((String) model.get("welcomeName"), todo.getDesc(), new Date(), false);
        return "redirect:/list-todos";
    }

    @RequestMapping(value="/update-todo", method = RequestMethod.GET)
    public String updateTodo(ModelMap model, @RequestParam int id) {

        List<Todo> todos = service.retrieveTodos((String) model.get("welcomeName"));
        Todo target = null;
        for (Todo todo : todos) {
            if (todo.getId() == id) {
                target = todo;
                break;
            }
        }

        model.put("todo", target);

        return "todo hibernate validator";
    }

    @RequestMapping(value="/update-todo", method = RequestMethod.POST)
    public String showUpdateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {

        if (result.hasErrors()) {
            return "todo hibernate validator";
        }

        todo.setUser((String) model.getAttribute("welcomeName"));
        service.updateTodo(todo);

        return "redirect:/list-todos";
    }




    @RequestMapping(value="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id) {
        service.deleteTodo(id);
        return "redirect:/list-todos";
    }
}
