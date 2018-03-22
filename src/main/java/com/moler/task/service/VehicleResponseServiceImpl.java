package com.moler.task.service;

import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;
import com.moler.task.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleResponseServiceImpl implements VehicleResponseService {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleResponseServiceImpl(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public VehicleResponse getVehicleResponse(VehicleQueryParameter parameter) {
        List<Vehicle> vehicles = vehicleService.getAll(parameter);
        return new VehicleResponse(200, vehicles);
    }
}
