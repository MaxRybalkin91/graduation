package ru.topjava.graduation.model.dto;

import ru.topjava.graduation.model.Meal;

import java.time.LocalDate;
import java.util.Objects;

public class MealTo {

    private Integer id;

    private String description;

    private Integer price;

    private LocalDate date;

    public MealTo(Meal m) {
        this.id = m.getId();
        this.description = m.getDescription();
        this.price = m.getPrice();
        this.date = m.getDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealTo mealTo = (MealTo) o;
        return Objects.equals(id, mealTo.id) &&
                Objects.equals(description, mealTo.description) &&
                Objects.equals(price, mealTo.price) &&
                Objects.equals(date, mealTo.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, price, date);
    }

    @Override
    public String toString() {
        return "MealTo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
