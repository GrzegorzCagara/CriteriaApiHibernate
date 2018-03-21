package com.moler.task.service;

import com.moler.task.dto.VehicleParameter;
import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;
import com.moler.task.entity.Point;
import com.moler.task.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    List<VehicleResponse> getAllVehicles(VehicleQueryParameter parameter);
    Vehicle getVehicleByTitle(String title);
    Vehicle getVehicleByDescription(String description);
    List<Vehicle> getAllVehicleAtPoint(Point point);
    void save(VehicleParameter vehicle);

    List<VehicleResponse> getAllVehicles(Optional<Integer> offset, Optional<String> text, Optional<List<Integer>> points);
}
