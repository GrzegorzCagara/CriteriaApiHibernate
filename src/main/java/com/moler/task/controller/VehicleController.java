package com.moler.task.controller;

import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;
import com.moler.task.entity.Vehicle;
import com.moler.task.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleController {

    private final VehicleService vehicleService;


    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody Vehicle vehicle){
        vehicleService.save(vehicle);
        return new ResponseEntity<>(vehicle.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/get")
    public ResponseEntity<List<VehicleResponse>> getAll(@RequestBody VehicleQueryParameter parameter){
        List<VehicleResponse> vehicles = vehicleService.getAllVehicles(parameter);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

    @GetMapping("/getsingle/{title}")
    public ResponseEntity<Vehicle> getOne(@PathVariable String title){
        Vehicle vehicle = vehicleService.getVehicleByTitle(title);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }


}
