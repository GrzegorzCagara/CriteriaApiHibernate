package com.moler.task.service;



import com.moler.task.entity.Point;
import com.moler.task.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointServiceImpl implements PointService {

    private final PointRepository pointRepository;

    @Autowired
    public PointServiceImpl(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    @Override
    public List<Point> getAll() {
        List<Point> points = pointRepository.getAll();
        return points;
    }

    @Override
    public Point save(Point point) {
        return pointRepository.save(point);
    }
}
