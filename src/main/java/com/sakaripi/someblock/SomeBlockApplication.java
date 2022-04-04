package com.sakaripi.someblock;


import com.sakaripi.someblock.model.Point;
import com.sakaripi.someblock.repo.PointRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SomeBlockApplication {

	public static void main(String[] args) {
		SpringApplication.run(SomeBlockApplication.class, args);
//		System.out.println(Math.round(Math.random() * (19998 - 10000 + 1)) + 10000);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(PointRepository pointRepository){
//		return args -> {
//			Point point = new Point("987654654", "5435154", "seeee@gmail.com");
//			pointRepository.save(point);
//		};
//	}
}
