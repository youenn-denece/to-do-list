package com.todolist.todolist.controller;

import com.todolist.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    ToDoService toDoService;
}
