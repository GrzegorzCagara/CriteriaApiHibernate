package com.moler.task.service;

import com.moler.task.dto.PointResponse;
import com.moler.task.entity.Point;
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
public class PointServiceTest {

    @Mock
    private PointResponse pointResponse;

    @Mock
    private Point point;

    @Mock
    private PointRepository pointRepository;

    @InjectMocks
    private PointServiceImpl pointService;

    @Test
    public void testSave(){
        when(pointRepository.save(point)).thenReturn(point);

        Point result = pointService.save(point);

        assertNotNull(result);
        verify(pointRepository, times(1)).save(point);
    }

//    @Test
//    public void testGetAll(){
//        List<Point> points = new ArrayList<>();
//        points.add(mock(Point.class));
//        points.add(mock(Point.class));
//        points.add(mock(Point.class));
//        points.add(mock(Point.class));
//        when(pointRepository.getAll()).thenReturn(points);
//
//        PointResponse result = pointService.getAll();
//        int pointsSize = points.size();
//
//        assertNotNull(result);
//        assertEquals(result.getData().size(), pointsSize);
//        verify(pointRepository, times(1)).getAll();
//    }
}
