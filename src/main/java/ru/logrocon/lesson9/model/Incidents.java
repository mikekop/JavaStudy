package ru.logrocon.lesson9.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "\"Incidents\"")
public class Incidents  {
    private UUID id;
    private String title;
    private String number;
    private Users user;


    @Id
    @Column(name = "\"Id\"")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Basic
    @Column(name = "\"Title\"")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "\"Number\"")
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Incidents incs = (Incidents) o;
        return id == incs.id && Objects.equals(title, incs.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @ManyToOne
    @JoinColumn(name = "\"OperatorId\"", referencedColumnName = "\"Id\"")
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}