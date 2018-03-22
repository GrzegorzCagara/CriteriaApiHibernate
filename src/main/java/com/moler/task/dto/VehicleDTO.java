package com.moler.task.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class VehicleDTO {
    private Long id;
    private String title;
    private String description;
    private Long point;

    public VehicleDTO(){}
}