package ru.topjava.graduation.model;

import java.util.Date;

public class Meal extends AbstractNamedEntity {

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
