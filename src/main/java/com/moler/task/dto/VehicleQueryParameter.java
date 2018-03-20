package com.moler.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class VehicleQueryParameter {
    private Integer offset;
    private String text;
    private List<Integer> points;

    public VehicleQueryParameter(){}
}
