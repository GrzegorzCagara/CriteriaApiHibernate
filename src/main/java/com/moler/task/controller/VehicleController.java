package com.moler.task.controller;

import com.moler.task.dto.VehicleDTO;
import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;
import com.moler.task.entity.Vehicle;
import com.moler.task.service.VehicleResponseService;
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

public class VehicleController {

    private final VehicleService vehicleService;
    private final VehicleResponseService vehicleResponseService;

    @Autowired
    public VehicleController(VehicleService vehicleService, VehicleResponseService vehicleResponseService) {
        this.vehicleService = vehicleService;
        this.vehicleResponseService = vehicleResponseService;
    }


    @PostMapping("/save")
    public ResponseEntity<Integer> save(@RequestBody VehicleDTO vehicle){
        Vehicle result = vehicleService.save(vehicle);
        return new ResponseEntity<>(result.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/get")
    public ResponseEntity<VehicleResponse> getAll(@RequestBody VehicleQueryParameter parameter){
        VehicleResponse vehicles = vehicleResponseService.getVehicleResponse(parameter);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }

}
