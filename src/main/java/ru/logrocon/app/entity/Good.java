package ru.logrocon.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "goods")
public class Good implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int goodId;
    @Column(nullable = false)
    private String name;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "goods_users",
            joinColumns = @JoinColumn(name = "id_good"),
            inverseJoinColumns = @JoinColumn(name = "id_user"))
    private Set<User> customers;

    @Transactional
    public void addCustomer(User customer) {
        customers.add(customer);
        customer.getGoods().add(this);
    }
    @Transactional
    public void removeCustomer(User customer) {
        customers.remove(customer);
        customer.getGoods().remove(this);
    }
}
