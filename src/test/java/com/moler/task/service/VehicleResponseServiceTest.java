package com.moler.task.service;

import com.moler.task.dto.VehicleQueryParameter;
import com.moler.task.dto.VehicleResponse;
import com.moler.task.entity.Vehicle;
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
public class VehicleResponseServiceTest {

    @Mock
    private VehicleResponse vehicleResponse;
    @Mock
    private Vehicle vehicle;
    @Mock
    private VehicleQueryParameter vehicleQueryParameter;
    @Mock
    private VehicleService vehicleService;
    @InjectMocks
    private VehicleResponseServiceImpl vehicleResponseService;

    @Test
    public void getVehicleResponseTest(){
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(mock(Vehicle.class));
        vehicles.add(mock(Vehicle.class));
        vehicles.add(mock(Vehicle.class));
        vehicles.add(mock(Vehicle.class));
        when(vehicleService.getAll(vehicleQueryParameter)).thenReturn(vehicles);

        VehicleResponse result = vehicleResponseService.getVehicleResponse(vehicleQueryParameter);
        int pointsSize = vehicles.size();

        assertNotNull(result);
        assertEquals(result.getData().size(), pointsSize);
        verify(vehicleService, times(1)).getAll(vehicleQueryParameter);
    }
}
