package com.example.pr2.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "_Type")
public class Type {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "_ID_Type")
        private int id;
        @NotBlank
        @Column(name = "_name")
        private String name;
        @NotBlank
        @Column(name = "_description")
        private String description;
        @NotBlank
        @Column(name = "_category")
        private String category;
    public Type(int id, String name, String description, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }
    public Type() { }
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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
}
