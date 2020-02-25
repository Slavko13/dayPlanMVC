package ru.dayplan.entity;


import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String login;
    private String first_name;
    private String second_name;
    private String password;
    private String logInTime;
    @Email
    private String email;
    private Integer age;
    private String fileName;

    public Client(String login, String first_name, String password, @Email String email) {
        this.login = login;
        this.first_name = first_name;
        this.password = password;
        this.email = email;
    }


    public Client() {
    }

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Tasks> tasksList = new ArrayList<>();


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @ManyToMany
    @JoinTable(name="client_home",
            joinColumns = @JoinColumn(name = "client_id"),
            inverseJoinColumns =@JoinColumn(name = "home_id") )
    private Set<Home> homes = new HashSet<>();

    public Set<Home> getHomes() {
        return homes;
    }

    public void setHomes(Set<Home> homes) {
        this.homes = homes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogInTime() {
        return logInTime;
    }

    public void setLogInTime(String logInTime) {
        this.logInTime = logInTime;
    }

}
