package com.moler.task.repository;

import com.moler.task.dto.VehicleParameter;
import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;
import com.moler.task.entity.Point;
import com.moler.task.entity.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    List<Vehicle> getAllVehicles(VehicleQueryParameter parameter);
    Vehicle getVehicleByTitle(String title);
    Vehicle getVehicleByDescription(String description);
    List<Vehicle> getAllVehicleAtPoint(Point point);
    void save(VehicleParameter vehicle);
    List<Vehicle> getAllVehicles(Optional<Integer> offset, Optional<String> text, Optional<List<Integer>> points);

}
