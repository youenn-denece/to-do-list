package com.todolist.todolist.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoList {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date date;
    private boolean status;

}
