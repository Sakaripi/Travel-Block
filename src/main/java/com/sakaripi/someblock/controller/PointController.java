package com.sakaripi.someblock.controller;

import com.sakaripi.someblock.exception.ExchangePointNotFoundException;
import com.sakaripi.someblock.model.Point;
import com.sakaripi.someblock.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/point")
public class PointController {

    @Autowired
    private final PointService pointService;

    public PointController(PointService pointService){
        this.pointService = pointService;
    }

    @GetMapping("/a")
    public List<Point> getPoints(){
        return pointService.getAllPoints();
    }

    @PostMapping("/rgns")
    public void registerNewSwap(@PathVariable String team, @RequestBody Point point){
        pointService.addNewPoint(point, team);
    }

    @GetMapping("/e")
    public Optional<Point> getPointByEmail(@RequestBody String email) throws ExchangePointNotFoundException {
        return pointService.getPointByGiverEmail(email);
    }

    @GetMapping("/lst")
    public Optional<Point> getTheLatestPoint(@PathVariable String team){
        return pointService.getLatestPoint(team);
    }
}
