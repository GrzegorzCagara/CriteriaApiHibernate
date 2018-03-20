package com.moler.task.repository;

import com.moler.task.entity.Point;

import java.util.List;

public interface PointRepository {
    List<Point> getAll();
    void save(Point point);
    Point getPointById(Long id);

}
