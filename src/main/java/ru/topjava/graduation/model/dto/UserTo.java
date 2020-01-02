package ru.topjava.graduation.model.dto;

import ru.topjava.graduation.model.Role;
import ru.topjava.graduation.model.User;

import java.util.Objects;
import java.util.Set;

public class UserTo {

    private Integer id;

    private String username;

    private String email;

    private String password;

    private Set<Role> roles;

    public UserTo(User u) {
        this.id = u.getId();
        this.username = u.getUsername();
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.roles = u.getRoles();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserTo userTo = (UserTo) o;
        return Objects.equals(id, userTo.id) &&
                Objects.equals(username, userTo.username) &&
                Objects.equals(email, userTo.email) &&
                Objects.equals(password, userTo.password) &&
                Objects.equals(roles, userTo.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, roles);
    }

    @Override
    public String toString() {
        return "UserTo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
