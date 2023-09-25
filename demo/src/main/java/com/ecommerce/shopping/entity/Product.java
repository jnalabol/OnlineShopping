package com.ecommerce.shopping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name ="product_id")
    public Integer productId;

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name ="name")
    public String name;
    @Column(name = "descr")
    public String desc;
    @Column(name ="price")
    public double price;

    public Integer getProductId() {
        return productId;
    }

    public void setId(Integer productId) {
        this.productId = productId;
    }



    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(Integer productId, String name, String desc, double price) {
        this.productId = productId;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }
    public Product(){}
}
