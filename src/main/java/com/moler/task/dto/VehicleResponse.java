package com.moler.task.dto;

import com.moler.task.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class VehicleResponse {
    private Integer status;
    private List<Vehicle> data;
}
