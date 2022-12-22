package com.todolist.todolist.service;

import com.todolist.todolist.entity.ToDoList;
import com.todolist.todolist.inteface.IDAO;
import com.todolist.todolist.tools.ServiceHibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService implements IDAO<ToDoList> {

    private ServiceHibernate serviceHibernate;
    private Session session;

    public ToDoService(ServiceHibernate serviceHibernate) {
        this.serviceHibernate = serviceHibernate;
        session = this.serviceHibernate.getSession();
    }

    @Override
    public boolean create(ToDoList o) {
        return false;
    }

    @Override
    public boolean update(ToDoList o) {
        return false;
    }

    @Override
    public boolean delete(ToDoList o) {
        return false;
    }

    @Override
    public ToDoList findById(int id) {
        return null;
    }

    @Override
    public List<ToDoList> findAll() {
        return null;
    }
}
