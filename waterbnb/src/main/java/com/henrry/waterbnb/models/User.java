package com.henrry.waterbnb.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
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

    public User() {
    }

    public void setPools(Pool pool) {
        this.pools.add(pool);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Review review) {
        this.reviews.add(review);
    }

    public List<Pool> getPools() {
        return pools;
    }

    public void setPools(List<Pool> pools) {
        this.pools = pools;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    

    
}
