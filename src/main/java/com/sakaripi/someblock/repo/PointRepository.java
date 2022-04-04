package com.sakaripi.someblock.repo;

import com.sakaripi.someblock.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {

    @Query(value = "SELECT p FROM Point p WHERE p.giverEmail = ?1")
    Optional<Point> findPointByGiverEmail(String giver_email);

    @Query(value = "SELECT p  FROM Point WHERE p.id")
    Optional<Point> findLatestPoint(String team);

}
