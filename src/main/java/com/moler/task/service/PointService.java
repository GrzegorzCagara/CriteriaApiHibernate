package com.moler.task.service;

import com.moler.task.entity.Point;

import java.util.List;

public interface PointService {
    List<Point> getAll();
    void save(Point point);
    Point getPointById(Long id);
}
