package com.moler.task.service;

import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;
import com.moler.task.entity.Point;
import com.moler.task.entity.Vehicle;
import com.moler.task.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;


    @Override
    public List<VehicleResponse> getAllVehicles(VehicleQueryParameter parameter) {
        List<Vehicle> vehicles = vehicleRepository.getAllVehicles(parameter);
        List<VehicleResponse> vehicleResponses = new LinkedList<>();
        vehicles.forEach(vehicle -> vehicleResponses.add(new VehicleResponse(200, vehicle)));
        return vehicleResponses;
    }

    @Override
    public Vehicle getVehicleByTitle(String title) {
        return vehicleRepository.getVehicleByTitle(title);
    }

    @Override
    public Vehicle getVehicleByDescription(String description) {
        return null;
    }

    @Override
    public List<Vehicle> getAllVehicleAtPoint(Point point) {
        return null;
    }

    @Override
    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
}
