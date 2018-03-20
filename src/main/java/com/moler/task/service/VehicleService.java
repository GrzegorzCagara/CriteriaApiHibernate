package com.moler.task.service;

import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;
import com.moler.task.entity.Point;
import com.moler.task.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<VehicleResponse> getAllVehicles(VehicleQueryParameter parameter);
    Vehicle getVehicleByTitle(String title);
    Vehicle getVehicleByDescription(String description);
    List<Vehicle> getAllVehicleAtPoint(Point point);
    void save(Vehicle vehicle);
}
