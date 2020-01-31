package ru.topjava.graduation.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class VoteToDate implements Serializable {
    private static final long serialVersionUID = 1L;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private Long count;

    public VoteToDate() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public VoteToDate(LocalDate date, Long count) {
        this.date = date;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteToDate voteToDate = (VoteToDate) o;
        return Objects.equals(date, voteToDate.date) &&
                Objects.equals(count, voteToDate.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, count);
    }

    @Override
    public String toString() {
        return "VoteTo{" +
                "date=" + date +
                ", count=" + count +
                '}';
    }
}
