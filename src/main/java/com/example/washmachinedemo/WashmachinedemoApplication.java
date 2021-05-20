package com.example.washmachinedemo;

import java.util.Timer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WashmachinedemoApplication {
	
	@Bean
    public Timer getTimer() {
        return new Timer();
    }

	public static void main(String[] args) {
		SpringApplication.run(WashmachinedemoApplication.class, args);
	}

}
