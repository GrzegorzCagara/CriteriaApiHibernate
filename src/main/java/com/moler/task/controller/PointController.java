package com.moler.task.controller;

import com.moler.task.dto.PointResponse;
import com.moler.task.entity.Point;
import com.moler.task.service.PointService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/points")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PointController {

    private final PointService pointService;

    @PostMapping("/save")
    public ResponseEntity<Long> save(@RequestBody Point point){
        pointService.save(point);
        return new ResponseEntity<>(point.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<PointResponse> get(){
        PointResponse points = pointService.getAll();
        return new ResponseEntity<>(points, HttpStatus.OK);
    }
}
