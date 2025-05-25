package com.example.employeepayrollapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        var context = SpringApplication.run(Application.class, args);

        // Get Environment from Spring context
        Environment env = context.getEnvironment();

        // Log the active Spring profiles
        String[] activeProfiles = env.getActiveProfiles();
        if (activeProfiles.length == 0) {
            log.info("No active Spring profile set. Using default settings.");
        } else {
            log.info("Active Spring profile(s): {}", String.join(", ", activeProfiles));
        }
    }
}
