package com.moler.task.service;

import com.moler.task.dto.VehicleResponse;
import com.moler.task.entity.Point;
import com.moler.task.entity.Vehicle;
import com.moler.task.repository.PointRepository;
import com.moler.task.repository.VehicleRepository;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;
    @Mock
    private VehicleResponse vehicleResponse;
    @Mock
    private Vehicle vehicle;
    @Mock
    private Point point;
    @Mock
    private PointRepository pointRepository;
    @InjectMocks
    private VehicleServiceImpl vehicleService;


}
