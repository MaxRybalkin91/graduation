package ru.topjava.graduation.model.dto;

import ru.topjava.graduation.model.Vote;

import java.time.LocalDate;
import java.util.Objects;

public class VoteTo {

    private Integer id;

    private LocalDate date;

    private Integer restaurantId;

    private String username;

    public VoteTo(Vote v) {
        this.id = v.getId();
        this.date = v.getDate();
        this.restaurantId = v.getRestaurant().getId();
        this.username = v.getUser().getUsername();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteTo voteTo = (VoteTo) o;
        return Objects.equals(id, voteTo.id) &&
                Objects.equals(date, voteTo.date) &&
                Objects.equals(restaurantId, voteTo.restaurantId) &&
                Objects.equals(username, voteTo.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, restaurantId, username);
    }

    @Override
    public String toString() {
        return "VoteTo{" +
                "id=" + id +
                ", date=" + date +
                ", restaurantId=" + restaurantId +
                ", username='" + username + '\'' +
                '}';
    }
}
