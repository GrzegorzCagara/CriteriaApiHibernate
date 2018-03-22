package com.moler.task.service;

import com.moler.task.dto.VehicleDTO;
import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;
import com.moler.task.entity.Point;
import com.moler.task.entity.Vehicle;
import com.moler.task.repository.PointRepository;
import com.moler.task.repository.VehicleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;
    @Mock
    private VehicleResponse vehicleResponse;
    @Mock
    private VehicleQueryParameter vehicleQueryParameter;
    @Mock
    private Vehicle vehicle;
    @Mock
    private Point point;
    @Mock
    private VehicleDTO vehicleDTO;
    @Mock
    private PointRepository pointRepository;
    @InjectMocks
    private VehicleServiceImpl vehicleService;


    @Test
    public void testGetAll(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(mock(Vehicle.class));
        vehicles.add(mock(Vehicle.class));
        vehicles.add(mock(Vehicle.class));
        vehicles.add(mock(Vehicle.class));
        when(vehicleRepository.getAll(vehicleQueryParameter)).thenReturn(vehicles);

        List<Vehicle> result = vehicleService.getAll(vehicleQueryParameter);
        int pointsSize = vehicles.size();

        assertNotNull(result);
        assertEquals(result.size(), pointsSize);
        verify(vehicleRepository, times(1)).getAll(vehicleQueryParameter);
    }



}
