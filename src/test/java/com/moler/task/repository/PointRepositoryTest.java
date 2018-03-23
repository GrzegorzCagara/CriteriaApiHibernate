package com.moler.task.repository;


import com.moler.task.entity.Point;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PointRepositoryTest {

    @Mock
    Point point;
    @Mock
    EntityManager em;
    @Mock
    CriteriaBuilder cb;
    @Mock
    CriteriaQuery<Point> query;
    @Mock
    Root<Point> rootPoint;
    @Mock
    TypedQuery<Point> q;
    @InjectMocks
    PointRepositoryImpl pointRepository;

    @Test
    public void testGetAll(){
        List<Point> points = new ArrayList<>();
        points.add(mock(Point.class));
        points.add(mock(Point.class));
        points.add(mock(Point.class));
        points.add(mock(Point.class));
        when(em.getCriteriaBuilder()).thenReturn(cb);
        when(cb.createQuery(Point.class)).thenReturn(query);
        when(query.from(Point.class)).thenReturn(rootPoint);
        when(em.createQuery(query)).thenReturn(q);
        when(q.getResultList()).thenReturn(points);

        List<Point> result = pointRepository.getAll();
        int pointsSize = points.size();

        assertNotNull(result);
        assertEquals(result.size(), pointsSize);
        verify(em, times(1)).getCriteriaBuilder();
        verify(em, times(1)).createQuery(query);
        verify(query, times(1)).from(Point.class);
        verify(cb, times(1)).createQuery(Point.class);
    }

    @Test
    public void testSave(){
        when(em.merge(point)).thenReturn(point);

        Point result = pointRepository.save(point);

        assertNotNull(result);
        verify(em, times(1)).merge(point);
    }
    
}
