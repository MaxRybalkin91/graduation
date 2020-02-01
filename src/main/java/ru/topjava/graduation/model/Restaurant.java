package ru.topjava.graduation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Address is a required field")
    @Size(min = 5, max = 50, message = "Address must have more than 5 and lower than 50 characters")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
    private Set<Meal> meals;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Restaurant() {
    }

    public Restaurant(String name, String address) {
        this(null, name, address);
    }

    public Restaurant(Integer id, String name, String address) {
        this(id, name, address, null);
    }

    public Restaurant(Integer id, String name, String address, User user) {
        super(id, name);
        this.address = address;
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name +
                ", address='" + address + '}';
    }
}