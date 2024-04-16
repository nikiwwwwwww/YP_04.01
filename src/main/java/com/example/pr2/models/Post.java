package com.example.pr2.models;

public class Post {
    private int id;
    private String name;
    private String description;
    private double salary;

    public Post(int id, String name, String description, double salary) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
