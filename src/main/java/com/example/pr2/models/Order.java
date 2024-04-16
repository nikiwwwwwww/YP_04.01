package com.example.pr2.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;


@Entity
@Table(name = "_Order")
public class Order {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "_ID_Order")
        private int id;
        @NotNull
        @Column(name = "_orderDate")
        private Date orderDate;
        @NotBlank
        @Column(name = "_name")
        private String name;
        @NotBlank
        @Column(name = "_status")
        private String status;
        public Order(int id, Date orderDate, String name, String status) {
                this.id = id;
                this.orderDate = orderDate;
                this.name = name;
                this.status = status;
        }
        public Order() { }
        public int getId() {
                return id;
        }
        public void setId(int id) {
                this.id = id;
        }
        public Date getOrderDate() {
                return orderDate;
        }
        public void setOrderDate(Date orderDate) {
                this.orderDate = orderDate;
        }
        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
        public String getStatus() {
                return status;
        }
        public void setStatus(String status) {
                this.status = status;
        }
}
