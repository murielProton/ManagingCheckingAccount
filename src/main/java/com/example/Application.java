package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Arobasse SpringBootApplication as our primary application configuration class, equivalent to @Configuration, 
 * @EnableAutoConfiguration, and @ComponentScan togethers
 */
@EnableJpaRepositories("com.example.repository") 
@EntityScan("com.example.model.entities")
@SpringBootApplication
public class Application {
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }
}
