package com.henrry.waterbnb.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "pools")
public class Pool extends BaseModel {
    @Size(min = 5, message = "Dirección debe tener más de 5 caracteres")
    private String address;
    @Size(min = 8, message = "Descripción debe tener más de 8 caracteres")
    private String description;
    @Size(min=2)
    private String size;
    @Min(45)
    private double cost;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User host;
    @OneToMany(mappedBy = "pool", fetch = FetchType.LAZY)
    private List<Review> reviews;

    public Pool() {
    }

    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
    }



    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public String getSize() {
        return size;
    }



    public void setSize(String size) {
        this.size = size;
    }



    public double getCost() {
        return cost;
    }



    public void setCost(double cost) {
        this.cost = cost;
    }



    public User getHost() {
        return host;
    }



    public void setHost(User host) {
        this.host = host;
    }



    public void setReview(Review review) {
        this.reviews.add(review);
    }
}

