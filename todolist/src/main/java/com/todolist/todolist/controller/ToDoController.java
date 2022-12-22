package com.todolist.todolist.controller;

import com.todolist.todolist.entity.ToDoList;
import com.todolist.todolist.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    ToDoService toDoService;

    @PostMapping("/add")
    public ToDoList addToDo(@RequestBody ToDoList toDo){
        if(toDoService.create(toDo)){
            return toDo;
        }
        return null;
    }
    @PostMapping("/update/{id}")
    public ToDoList updateToDoById(@PathVariable("id") Integer id, @RequestBody ToDoList toDo){
        ToDoList toDoExist = toDoService.findById(id);
        if(toDoExist != null) {
            toDoExist.setTitle(toDo.getTitle());
            toDoExist.setDescription(toDo.getDescription());
            toDoExist.setDate(toDo.getDate());
            toDoExist.setStatus(toDo.isStatus());
            if(toDoService.update(toDoExist)){
                return toDoExist;
            }
        }
        return toDoExist;
    }

    @GetMapping("/delete/{id}")
    public String deleteToDoById(@PathVariable("id") Integer id) {
        ToDoList toDo = toDoService.findById(id);
        if(toDo != null && toDoService.delete(toDo)) {
            return "La tâche à bien été supprimée";
        }
        return "Aucune tâche n'existe avec l'id : " + id;
    }

    @PostMapping("/updatestatus/{id}")
    public ToDoList updateStatus(@PathVariable("id") Integer id, @RequestBody ToDoList toDo){
        ToDoList toDoExist = toDoService.findById(id);
        if(toDoExist != null) {
            toDoExist.setStatus(toDo.isStatus());
            if(toDoService.updateStatus(toDoExist)){
                return toDoExist;
            }
        }
        return toDoExist;
    }
}
