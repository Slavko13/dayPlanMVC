package ru.dayplan.entity;


import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.sql.Time;

@Entity
public class Tasks {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer roadTime;
    private String taskName;
    private String time;
    private String taskDescription;
    private String address;
    private Integer holdingTime;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getHoldingTime() {
        return holdingTime;
    }

    public void setHoldingTime(Integer holdingTime) {
        this.holdingTime = holdingTime;
    }

    public Integer getRoadTime() {
        return roadTime;
    }

    public void setRoadTime(Integer roadTime) {
        this.roadTime = roadTime;
    }
}
