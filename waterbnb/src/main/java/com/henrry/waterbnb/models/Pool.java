package com.henrry.waterbnb.models;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "pools")
@Getter @Setter @NoArgsConstructor
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

    public void setReview(Review review) {
        this.reviews.add(review);
    }

    // metodos


    public float averageRating() {
        int suma = 0;
        for(int i = 0; i < reviews.size(); i++) {
            suma+=reviews.get(i).getRating();
        }

        return suma/reviews.size();
    }
}

