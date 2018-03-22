package com.moler.task.entity;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@ToString
public class Point {
    @Id
    private Integer id;
    private String name;

    public Point() {}

    public Point(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
