package com.moler.task.controller;

import com.moler.task.dto.PointResponse;
import com.moler.task.entity.Point;
import com.moler.task.service.PointResponseService;
import com.moler.task.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/points")
public class PointController {

    private final PointService pointService;
    private final PointResponseService pointResponseService;

    @Autowired
    public PointController(PointService pointService, PointResponseService pointResponseService) {
        this.pointService = pointService;
        this.pointResponseService = pointResponseService;
    }

    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody Point point){
        Point result = pointService.save(point);
        return new ResponseEntity<>(result.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<PointResponse> get(){
        PointResponse points = pointResponseService.getPointResponse();
        return new ResponseEntity<>(points, HttpStatus.OK);
    }
}
