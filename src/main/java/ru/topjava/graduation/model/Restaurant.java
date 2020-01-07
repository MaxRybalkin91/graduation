package ru.topjava.graduation.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {

    @NotBlank
    @Size(min = 5, max = 50)
    private String address;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private Date registered;

    private boolean isEnabled = true;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Meal> meals;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private List<Vote> voteList;

    public Restaurant() {
    }

    public Restaurant(String name, String address) {
        this(null, name, address, Collections.EMPTY_LIST);
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