package com.example.pr2.models;


import javax.persistence.*;
import javax.validation.constraints.*;
@Entity
@Table(name = "OrderDetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "order_id", unique = true)
    private Order order;

    @Column(name = "details")
    @NotBlank
    private String details;

    public OrderDetails(int id, Order order, String details) {
        this.id = id;
        this.order = order;
        this.details = details;
    }
    public OrderDetails() {

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
}