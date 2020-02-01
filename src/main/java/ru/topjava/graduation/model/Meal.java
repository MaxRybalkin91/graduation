package ru.topjava.graduation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "meals")
public class Meal extends AbstractNamedEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "Price must be added")
    private Integer price;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Restaurant restaurant;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    public Meal() {
    }

    public Meal(String name, Integer price) {
        this(null, name, price, LocalDate.now(), null);
    }

    public Meal(Meal m) {
        this(m.getId(), m.getName(), m.getPrice(), m.getDate(), m.getUser());
    }

    public Meal(Integer id, String name, Integer price) {
        this(id, name, price, LocalDate.now(), null);
    }

    public Meal(Integer id, String name, Integer price, LocalDate date) {
        this(id, name, price, date, null);
    }

    public Meal(Integer id, String name, Integer price, User user) {
        this(id, name, price, LocalDate.now(), user);
    }

    public Meal(Integer id, String name, Integer price, LocalDate date, User user) {
        super(id, name);
        this.price = price;
        this.date = date != null ? date : LocalDate.now();
        this.user = user;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name=" + name +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}