package com.student.score;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StudentScoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentScoreApplication.class, args);
	}

}
