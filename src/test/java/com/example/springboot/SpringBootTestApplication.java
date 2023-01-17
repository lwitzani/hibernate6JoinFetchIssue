package com.example.springboot;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication(scanBasePackages = "com.example.springboot")
@EntityScan("com.example.springboot")
@EnableJpaRepositories("com.example.springboot")
@ActiveProfiles("test")
public class SpringBootTestApplication {
}
