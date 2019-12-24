package ru.topjava.graduation.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractNamedEntity {

    private Integer votes = 0;
    private Date registered;

    private String address;

    public Restaurant() {
    }

    public Restaurant(String name, String address) {
        super(name);
        this.address = address;
    }

    private Date voteDate;

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

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public Date getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(Date voteDate) {
        this.voteDate = voteDate;
    }
}
