package com.example.k224111488dokhanhlinh.models;

import androidx.annotation.NonNull;

import java.io.Serializable;
public class Product implements Serializable {
    private int id;
    private String productCode;
    private String name;
    private double price;
    private String imageLink;

    public Product() {
    }

    public Product(int id, String productCode, String name, double price, String imageLink) {
        this.id = id;
        this.productCode = productCode;
        this.name = name;
        this.price = price;
        this.imageLink = imageLink;
    }

    // Getter và Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    @NonNull
    @Override
    public String toString() {
        return id + "-" + name;
    }
}