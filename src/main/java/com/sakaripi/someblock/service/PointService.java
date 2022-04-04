package com.sakaripi.someblock.service;

import com.sakaripi.someblock.exception.ExchangePointNotFoundException;
import com.sakaripi.someblock.model.Point;
import com.sakaripi.someblock.model.Team;
import com.sakaripi.someblock.repo.PointRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class PointService {

    private static final Logger logger = LoggerFactory.getLogger(PointService.class);

    private final PointRepository pointRepository;

    @Autowired
    public PointService(PointRepository pointRepository) {
        this.pointRepository = pointRepository;
    }

    public List<Point> getAllPoints(){
        return pointRepository.findAll();
    }

    //retrieve exchange point by giver email
    public Optional<Point> getPointByGiverEmail(String email) {
            Optional<Point> point =  pointRepository.findPointByGiverEmail(email);

            try {
                if(point.isEmpty()){
                    throw new ExchangePointNotFoundException("Exchange point not found with giver email " + email);
                }
            }
            catch (ExchangePointNotFoundException e) {
                logger.error("No exchange point found with giver email " + email);
            }
            return point;
    }

    public Optional<Point> getLatestPoint(String team){
        logger.info("fetching the latest point for team: " + team);
        return pointRepository.findLatestPoint(team);
    }

    public void addNewPoint(Point point, String team){

        if(point == null || team.isEmpty()){
            throw new IllegalStateException("empty or null value trying to add new point");
        }
        switch (team){
            case "UMJRPCpgE4":
                point.setTeam(Team.RED); break;
            case "TJsAPHwyLS":
                point.setTeam(Team.BLUE); break;
            case "N6y76G32ps":
                point.setTeam(Team.YELLOW); break;
            case "pxDXyo3lJs":
                point.setTeam(Team.PURPLE); break;
            case "tMM56ctvrK":
                point.setTeam(Team.ORANGE); break;
            case "ZOJRb0MEQP":
                point.setTeam(Team.GREEN); break;
        }
        logger.info("Attempting to save new exchange point to the db ofr team: " + team);

        if(checkEmailAvailability(point.getGiverEmail())){
            try{
                pointRepository.save(point);
                logger.info("Exchange point saved: " + point);
            } catch (Exception e){
                logger.info("Error trying to save exchange point");
                e.printStackTrace();
            }
        }
        else {
            logger.error("Email already taken. Point not saved.");
        }
    }

    //return true if email is available and not found in the db
    private boolean checkEmailAvailability(String email){
        Optional<Point> point = getPointByGiverEmail(email);
        return point.isPresent();
    }

}
