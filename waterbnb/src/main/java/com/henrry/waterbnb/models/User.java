package com.henrry.waterbnb.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class User extends BaseModel {
    @Size(min=2)
    private String firstName;
    @Size(min=2)
    private String lastName;
    @Email(message = "Email debe ser válido")
    private String email;
    @Size(min = 5, message = "Password debe ser mayor a 5 caracteres")
    private String password;
    @Transient
    private String passwordConfirmation;
    @Min(1)
    @Max(2)
    private int rol;

    @OneToMany(mappedBy = "host", fetch = FetchType.LAZY)
    private List<Pool> pools;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Review> reviews;

    public void addPools(Pool pool) {
        this.pools.add(pool);
    }
    public void addReviews(Review review) {
        this.reviews.add(review);
    }

}
