package ru.topjava.graduation.model.dto;

import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.model.Restaurant;
import ru.topjava.graduation.model.Vote;

import java.util.List;
import java.util.Objects;

public class RestaurantTo {

    private Integer id;

    private String name;

    private String address;

    private List<Vote> voteList;

    private List<Meal> mealList;

    public RestaurantTo(Restaurant r) {
        this.id = r.getId();
        this.name = r.getName();
        this.address = r.getAddress();
        this.voteList = r.getVoteList();
        this.mealList = r.getMeals();
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

    public List<Vote> getVoteList() {
        return voteList;
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }

    public List<Meal> getMealList() {
        return mealList;
    }

    public void setMealList(List<Meal> mealList) {
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
                Objects.equals(voteList, that.voteList) &&
                Objects.equals(mealList, that.mealList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, voteList, mealList);
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", voteList=" + voteList +
                ", mealList=" + mealList +
                '}';
    }
}