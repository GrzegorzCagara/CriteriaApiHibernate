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
        when(em.getCriteriaBuilder()).thenReturn(cb);
        when(cb.createQuery(Point.class)).thenReturn(query);
        when(query.from(Point.class)).thenReturn(rootPoint);
        when(em.createQuery(query)).thenReturn(q);
        
        verify(em, times(1)).getCriteriaBuilder();
        verify(em, times(1)).createQuery(query);
        verify(query, times(1)).from(Point.class);
        verify(cb, times(1)).createQuery(Point.class);
    }
}
