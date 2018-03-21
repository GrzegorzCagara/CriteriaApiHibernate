package com.moler.task.dto;

import com.moler.task.entity.Point;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PointResponse {
    private Integer status;
    private List<Point> data;
}
