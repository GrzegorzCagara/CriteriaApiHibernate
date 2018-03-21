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
    public PointResponse getAll() {
        List<Point> points = pointRepository.getAll();
        return new PointResponse(200, points);
    }

    @Override
    public void save(Point point) {
        pointRepository.save(point);
    }
}
