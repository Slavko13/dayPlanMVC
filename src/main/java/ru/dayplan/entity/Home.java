package ru.dayplan.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String homeName;
    private String address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "client_home",
            joinColumns = {@JoinColumn(name = "home_id")},
            inverseJoinColumns = {@JoinColumn(name = "client_id")})
    private Set<Client> clients = new HashSet<>();

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }


}
