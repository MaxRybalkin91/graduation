package ru.topjava.graduation.model.dto;

import ru.topjava.graduation.model.Restaurant;

public class RestaurantTo {
    private final Integer id;

    private final String name;

    private final String address;

    private final boolean isEnabled;

    public RestaurantTo(Restaurant r) {
        this.id = r.getId();
        this.name = r.getName();
        this.address = r.getAddress();
        this.isEnabled = r.isEnabled();
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

    public boolean isEnabled() {
        return isEnabled;
    }
}
