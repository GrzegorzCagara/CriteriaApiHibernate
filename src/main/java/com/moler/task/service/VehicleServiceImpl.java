package com.moler.task.service;

import com.moler.task.dto.VehicleDTO;
import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.entity.Point;
import com.moler.task.entity.Vehicle;
import com.moler.task.repository.PointRepository;
import com.moler.task.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{

    private final VehicleRepository vehicleRepository;
    private final PointRepository pointRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository, PointRepository pointRepository) {
        this.vehicleRepository = vehicleRepository;
        this.pointRepository = pointRepository;
    }

    @Override
    public List<Vehicle> getAll(VehicleQueryParameter parameter) {
        return vehicleRepository.getAll(parameter);
    }

    @Override
    public Vehicle save(VehicleDTO vehicleDTO) {
        Point point = pointRepository.getPointById(vehicleDTO.getPoint());
        Vehicle vehicle = new Vehicle(vehicleDTO.getId(), vehicleDTO.getTitle(), vehicleDTO.getDescription(), point);
        return vehicleRepository.save(vehicle);
    }

}
