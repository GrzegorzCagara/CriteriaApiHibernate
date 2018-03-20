package com.moler.task.dto;

import com.moler.task.entity.Point;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PointResponse {
    private Integer status;
    private Point data;
}
