package com.moler.task.dto;

import com.moler.task.entity.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class VehicleResponse {
    private Integer status;
    private Vehicle data;
}
