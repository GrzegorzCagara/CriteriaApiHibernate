package com.moler.task.service;

import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;

public interface VehicleResponseService {

    VehicleResponse getVehicleResponse(VehicleQueryParameter parameter);
}
