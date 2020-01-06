package ru.topjava.graduation.model.dto;

import ru.topjava.graduation.model.Restaurant;

import java.util.List;
import java.util.Objects;

import static ru.topjava.graduation.util.converter.MealUtil.mealTos;

public class RestaurantTo {

    private Integer id;

    private String name;

    private String address;

    private Integer votes;

    private List<MealTo> mealList;

    public RestaurantTo(Restaurant r) {
        this(r.getId(), r.getName(),
                r.getAddress(),
                r.getVoteList().size(),
                mealTos(r.getMeals()));
    }

    public RestaurantTo(Integer id, String name, String address, Integer votes, List<MealTo> mealList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.votes = votes;
        this.mealList = mealList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public List<MealTo> getMealList() {
        return mealList;
    }

    public void setMealList(List<MealTo> mealList) {
        this.mealList = mealList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantTo that = (RestaurantTo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address) &&
                Objects.equals(votes, that.votes) &&
                Objects.equals(mealList, that.mealList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, votes, mealList);
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", votes=" + votes +
                ", mealList=" + mealList +
                '}';
    }
}