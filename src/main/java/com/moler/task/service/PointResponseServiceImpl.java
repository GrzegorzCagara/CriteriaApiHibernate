package com.moler.task.service;

import com.moler.task.dto.PointResponse;
import com.moler.task.entity.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PointResponseServiceImpl implements PointResponseService{

    private final PointService pointService;

    @Autowired
    public PointResponseServiceImpl(PointService pointService) {
        this.pointService = pointService;
    }

    public PointResponse getPointResponse(){
        List<Point> points = pointService.getAll();
        return new PointResponse(200, points);
    }
}
