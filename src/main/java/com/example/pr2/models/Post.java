package com.example.pr2.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "_Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "_ID_Post")
    private int id;
    @NotBlank
    @Column(name = "_name")
    private String name;
    @NotBlank
    @Column(name = "_description")
    private String description;
    @NotBlank
    @Column(name = "_salary")
    private double salary;
    public Post(int id, String name, String description, double salary) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.salary = salary;
    }
    public Post() { }
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
