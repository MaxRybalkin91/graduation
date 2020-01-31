package ru.topjava.graduation.model.dto;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import ru.topjava.graduation.model.Meal;
import ru.topjava.graduation.model.Restaurant;

import javax.persistence.Cacheable;
import java.io.Serializable;
import java.util.Set;

@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RestaurantTo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String address;

    private Set<Meal> meals;

    public RestaurantTo() {
    }

    public RestaurantTo(Restaurant r) {
        this(r.getId(), r.getName(), r.getAddress(), r.getMeals());
    }

    public RestaurantTo(Restaurant r, Set<Meal> meals) {
        this(r.getId(), r.getName(), r.getAddress(), meals);
    }

    public RestaurantTo(Integer id, String name, String address, Set<Meal> meals) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.meals = meals;
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

    public Set<Meal> getMeals() {
        return meals;
    }

    public void setMeals(Set<Meal> meals) {
        this.meals = meals;
    }

    @Override
    public String toString() {
        return "RestaurantTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", meals=" + meals +
                '}';
    }
}