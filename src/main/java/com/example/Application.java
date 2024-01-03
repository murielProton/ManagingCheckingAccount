package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Arobasse SpringBootApplication as our primary application configuration class, equivalent to @Configuration, 
 * @EnableAutoConfiguration, and @ComponentScan togethers
 */
@SpringBootApplication
public class Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(Application.class, args);
    }
}
