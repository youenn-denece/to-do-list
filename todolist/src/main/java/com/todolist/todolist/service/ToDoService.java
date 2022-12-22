package com.todolist.todolist.service;

import com.todolist.todolist.entity.ToDoList;
import com.todolist.todolist.inteface.IDAO;
import com.todolist.todolist.tools.ServiceHibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.hibernate.query.Query;
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
        session.beginTransaction();
        session.persist(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean update(ToDoList o) {
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public boolean delete(ToDoList o) {
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        return true;
    }

    @Override
    public ToDoList findById(int id) {
        ToDoList toDo = null;
        toDo = (ToDoList) session.get(ToDoList.class, id);
        return toDo;
    }

    @Override
    public List<ToDoList> findAll() {
        Query<ToDoList> toDoQuery = session.createQuery("from ToDoList", ToDoList.class);
        return toDoQuery.list();

    }
}
