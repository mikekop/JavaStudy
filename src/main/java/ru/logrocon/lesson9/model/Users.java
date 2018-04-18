package ru.logrocon.lesson9.model;

import javax.persistence.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "\"Users\"")
public class Users {
    private UUID id;
    private String userName;
    private String password;
    private Collection<Incidents> incidents;

    @Id
    @Column(name = "\"Id\"")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "\"UserName\"")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String login) {
        this.userName = login;
    }

    @Basic
    @Column(name = "\"Password\"")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                Objects.equals(userName, users.userName) &&
                Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, userName, password);
    }

    @OneToMany(mappedBy = "user")
    public Collection<Incidents> getIncidents() {
        return incidents;
    }

    public void setIncidents(Collection<Incidents>incidents) {
        this.incidents = incidents;
    }
}