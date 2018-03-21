package com.moler.task.service;

import com.moler.task.dto.VehicleParameter;
import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;
import com.moler.task.entity.Point;
import com.moler.task.entity.Vehicle;
import com.moler.task.repository.PointRepository;
import com.moler.task.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;
    private final PointRepository pointRepository;


    @Override
    public VehicleResponse getAllVehicles(VehicleQueryParameter parameter) {
        List<Vehicle> vehicles = vehicleRepository.getAllVehicles(parameter);
        return new VehicleResponse(200, vehicles);
    }



    @Override
    public void save(VehicleParameter vehicleParameter) {
        Point point = pointRepository.getPointById(vehicleParameter.getPoint());
        Vehicle vehicle = new Vehicle(vehicleParameter.getId(), vehicleParameter.getTitle(), vehicleParameter.getDescription(), point);
        vehicleRepository.save(vehicle);
    }

}
