package com.example.pr2.models;

import java.sql.Date;

public class Order {
        private int id;
        private Date orderDate;
        private String name;
        private String status;

        public Order(int id, Date orderDate, String name, String status) {
                this.id = id;
                this.orderDate = orderDate;
                this.name = name;
                this.status = status;
        }

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
