package com.moler.task.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Optional;

@Getter
@ToString
@AllArgsConstructor
public class VehicleQueryParameter {
    private Optional<Integer> offset;
    private Optional<String> text;
    private Optional<List<Long>> points;

    public VehicleQueryParameter(){}
}
