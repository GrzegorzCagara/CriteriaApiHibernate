package com.moler.task.service;

import com.moler.task.dto.VehicleParameter;
import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;

public interface VehicleService {
    VehicleResponse getAllVehicles(VehicleQueryParameter parameter);
    void save(VehicleParameter vehicleParameter);
}
