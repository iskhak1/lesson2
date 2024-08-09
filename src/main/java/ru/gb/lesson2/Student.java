package ru.gb.lesson2;

import org.springframework.context.annotation.Bean;

import java.util.UUID;


public class Student {
    private Long id;
    private String name;
    private String group_name;

    public Student(Long id,String name, String group_name) {
        this.id = id;
        this.name = name;
        this.group_name = group_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }
}
