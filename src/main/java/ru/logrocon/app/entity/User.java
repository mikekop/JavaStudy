package ru.logrocon.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class User implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int userId;
    @Column(unique = true, nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Message> messages;
    @ManyToMany(mappedBy = "customers")
    private Set<Good> goods;

    public void addGood(Good good){
        good.addCustomer(this);
    }

    public void removeGood(Good good){
        good.removeCustomer(this);
    }
}
