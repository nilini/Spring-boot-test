package com.springboottest.example.Domain;

import java.io.Serializable;

public class Book implements Serializable {
    private Integer id;
    private String name;
    private String author;
    private String image;
    private Double price;
    private String remark;

    public Book() {
        super();
    }

    public Book(Integer id, String name, String author, String image, Double price, String remark) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.image = image;
        this.price = price;
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getImage() {
        return image;
    }

    public Double getPrice() {
        return price;
    }

    public String getRemark() {
        return remark;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
