package com.todolist.todolist.tools;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

@Service
public class ServiceHibernate {

    private Session _session;

    public ServiceHibernate() {
        try {
            _session = HibernateUtil.getSesssionFactory().openSession();
        }catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
    public Session getSession() {return HibernateUtil.getSesssionFactory().openSession();}
}
