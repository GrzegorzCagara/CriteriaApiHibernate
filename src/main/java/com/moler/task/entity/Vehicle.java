package com.moler.task.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@ToString
public class Vehicle {
    @Id
    private Integer id;
    private String title;
    private String description;
    @ManyToOne
    private Point point;

    public Vehicle(){}

    public Vehicle(Integer id, String title, String description, Point point) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.point = point;
    }
}
