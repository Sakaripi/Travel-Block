package com.sakaripi.someblock.service;

import com.sakaripi.someblock.model.Point;
import com.sakaripi.someblock.model.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PointServiceTest {

    @Autowired
    private PointService pointService;

    private final Point pointWithCorrectData = new Point("50.123456789", "100.123456789", "testEmail@gmail.com", Team.BLUE);


    @BeforeEach
    void setUp() {

    }

    @Test
    void getAllPoints() {
    }

    @Test
    void getPointByGiverEmail() {
    }

    @Test
    void addNewPoint() {
    }

}