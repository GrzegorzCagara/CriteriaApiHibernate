package com.moler.task.service;

import com.moler.task.dto.PointResponse;
import com.moler.task.dto.VehicleResponse;
import com.moler.task.entity.Point;
import com.moler.task.entity.Vehicle;
import com.moler.task.repository.PointRepository;
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
public class PointResponseServiceTest {

    @Mock
    private PointResponse pointResponse;
    @Mock
    private Point point;
    @Mock
    private PointRepository pointRepository;
    @Mock
    private PointServiceImpl pointService;
    @InjectMocks
    private PointResponseServiceImpl pointResponseService;

    @Test
    public void getPointResponseTest(){
        List<Point> points = new ArrayList<>();
        points.add(mock(Point.class));
        points.add(mock(Point.class));
        points.add(mock(Point.class));
        points.add(mock(Point.class));
        when(pointService.getAll()).thenReturn(points);

        PointResponse result = pointResponseService.getPointResponse();
        int pointsSize = points.size();

        assertNotNull(result);
        assertEquals(result.getData().size(), pointsSize);
        verify(pointService, times(1)).getAll();
    }
}
