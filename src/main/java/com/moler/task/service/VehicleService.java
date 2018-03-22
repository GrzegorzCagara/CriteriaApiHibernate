package com.moler.task.service;

import com.moler.task.dto.VehicleDTO;
import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;
import com.moler.task.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> getAll(VehicleQueryParameter parameter);
    Vehicle save(VehicleDTO vehicleDTO);
}
