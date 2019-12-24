package ru.topjava.graduation.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "restaurant_meals")
public class Meal extends AbstractNamedEntity {

    public Meal() {
    }

    private Integer price;

    private Date mealDate;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getMealDate() {
        return mealDate;
    }

    public void setMealDate(Date mealDate) {
        this.mealDate = mealDate;
    }
}
