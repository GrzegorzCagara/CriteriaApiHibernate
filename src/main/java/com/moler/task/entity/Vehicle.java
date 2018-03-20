package com.moler.task.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
public class Vehicle {
    @Id
    private Long id;
    private String title;
    private String description;
    @ManyToOne
    private Point point;

    public Vehicle(){}

    public Vehicle(Long id, String title, String description, Point point) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.point = point;
    }
}
