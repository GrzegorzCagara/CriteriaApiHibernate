package com.moler.task.service;

import com.moler.task.dto.PointResponse;
import com.moler.task.entity.Point;

public interface PointService {
    PointResponse getAll();
    void save(Point point);
}
