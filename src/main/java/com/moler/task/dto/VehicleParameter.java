package com.moler.task.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VehicleParameter {
    private Long id;
    private String title;
    private String description;
    private Long point;

    public VehicleParameter(){}
}
