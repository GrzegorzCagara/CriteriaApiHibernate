package com.moler.task.controller;

import com.moler.task.dto.VehicleParameter;
import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;
import com.moler.task.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VehicleController {

    private final VehicleService vehicleService;


    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody VehicleParameter vehicle){
        vehicleService.save(vehicle);
        return new ResponseEntity<>(vehicle.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/get")
    public ResponseEntity<VehicleResponse> getAll(@RequestBody VehicleQueryParameter parameter){
        VehicleResponse vehicles = vehicleService.getAllVehicles(parameter);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }


}
