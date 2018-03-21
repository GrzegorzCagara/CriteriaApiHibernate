package com.moler.task.repository;

import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.entity.Vehicle;

import java.util.List;

public interface VehicleRepository {
    List<Vehicle> getAllVehicles(VehicleQueryParameter parameter);
    void save(Vehicle vehicle);


}
