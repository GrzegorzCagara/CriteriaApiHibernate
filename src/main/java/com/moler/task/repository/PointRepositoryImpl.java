package com.moler.task.repository;

import com.moler.task.entity.Point;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PointRepositoryImpl implements PointRepository{

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<Point> getAll() {

        return null;
    }

    @Override
    @Transactional
    public void save(Point point) {
        em.merge(point);
    }

    @Override
    @Transactional
    public Point getPointById(Long id) {
        return null;
    }
}
