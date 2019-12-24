package ru.topjava.graduation.model;

public abstract class AbstractNamedEntity extends AbstractBaseEntity {

    private String name;

    protected AbstractNamedEntity() {
    }

    protected AbstractNamedEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
