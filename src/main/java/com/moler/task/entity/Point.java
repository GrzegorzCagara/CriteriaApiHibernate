package com.moler.task.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@ToString
public class Point {
    @Id
    private Long id;
    private String name;

    public Point() {}

    public Point(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
