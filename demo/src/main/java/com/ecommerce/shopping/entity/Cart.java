package com.ecommerce.shopping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @Column(name ="id")
    public Integer id;
    @Column(name ="quantity")
    public int quantity;

    @Column(name ="name")
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart(Integer id, int quantity, String name) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
    }
    public Cart(){}
}
