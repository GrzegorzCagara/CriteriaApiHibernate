package com.moler.task.service;


import com.moler.task.dto.PointResponse;
import com.moler.task.entity.Point;
import com.moler.task.repository.PointRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PointServiceImpl implements PointService {

    private final PointRepository pointRepository;

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
