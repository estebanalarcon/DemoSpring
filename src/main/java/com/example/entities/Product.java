package com.example.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "product")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    //Esta es la id del producto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private Integer price;

    @Column(name="expiration_date")
    private Date expirationDate;

    @Column(name="category_id")
    private Integer category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCost() {
        return this.price;
    }

    public void setCost(Integer cost) {
        this.price = cost;
    }

    public Date getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(Date expiration) {
        this.expirationDate = expiration;
    }

    public Integer getCategory() {
        return this.category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }
}
