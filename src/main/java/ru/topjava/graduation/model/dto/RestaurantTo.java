package ru.topjava.graduation.model.dto;

import ru.topjava.graduation.model.Restaurant;

import java.util.Objects;

public class RestaurantTo {
    private final Integer id;

    private final String name;

    private final String address;

    public RestaurantTo(Restaurant r) {
        this.id = r.getId();
        this.name = r.getName();
        this.address = r.getAddress();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RestaurantTo that = (RestaurantTo) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address);
    }
}
