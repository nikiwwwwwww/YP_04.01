package com.example.pr2.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PersonOrders")
public class PersonOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public PersonOrders(int id, Person person, Order order) {
        this.id = id;
        this.person = person;
        this.order = order;
    }
    public PersonOrders() {

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) { this.person = person; }
    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
}