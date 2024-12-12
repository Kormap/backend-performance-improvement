package com.performance.improvement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PerformanceImprovementProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(PerformanceImprovementProjectApplication.class, args);
    }

}
