package ru.topjava.graduation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;
import ru.topjava.graduation.util.DateTimeUtil;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity implements Serializable {

    @NotBlank
    @Size(min = 5, max = 50)
    private String address;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @DateTimeFormat(pattern = DateTimeUtil.DATE_TIME_PATTERN)
    @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()")
    private Date registered = new Date();

    private boolean isEnabled = true;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Meal> meals;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Vote> voteList;

    public Restaurant() {
    }

    public Restaurant(String name, String address) {
        this(null, name, address);
    }

    public Restaurant(Integer id, String name, String address) {
        this(id, name, address, Collections.EMPTY_LIST);
    }

    public Restaurant(Integer id, String name, String address, List<Meal> meals) {
        super(id, name);
        this.address = address;
        this.meals = meals;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
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