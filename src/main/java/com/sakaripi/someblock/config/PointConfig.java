package com.sakaripi.someblock.config;

import com.sakaripi.someblock.model.Point;
import com.sakaripi.someblock.model.Team;
import com.sakaripi.someblock.repo.PointRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PointConfig {

    @Bean
    CommandLineRunner commandLineRunner(PointRepository pointRepository){
        return args -> {
            pointRepository.saveAll(List.of(
                    new Point("123.456789", "321.987654", "sepo@gmail.com", Team.BLUE),
                    new Point("987654654", "5435154", "seeee@gmail.com", Team.RED)));
        };
    }
}
