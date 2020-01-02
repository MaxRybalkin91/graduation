package ru.topjava.graduation.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Please fill the name")
    private String name;

    @NotBlank(message = "Please fill the address")
    private String address;

    private LocalDateTime registered;

    private boolean isEnabled = true;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Meal> meals;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "restaurant")
    private List<Vote> voteList;

    public Restaurant() {
    }

    public Restaurant(String name, String address, List<Meal> meals) {
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

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public List<Vote> getVoteList() {
        return new ArrayList<>(voteList);
    }

    public void setVoteList(List<Vote> voteList) {
        this.voteList = voteList;
    }

    public List<Meal> getMeals() {
        return new ArrayList<>(meals);
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }

    public boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}