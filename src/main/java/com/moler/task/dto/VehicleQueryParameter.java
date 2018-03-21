package com.moler.task.dto;

import com.moler.task.entity.Point;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

@Getter
@AllArgsConstructor
public class VehicleQueryParameter {
    private Optional<Integer> offset;
    private Optional<String> text;
    private Optional<List<Integer>> points;

    public VehicleQueryParameter(){}
}
