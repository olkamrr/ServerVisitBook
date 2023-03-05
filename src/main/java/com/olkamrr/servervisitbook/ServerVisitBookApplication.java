package com.olkamrr.servervisitbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.olkamrr.servervisitbook")
public class ServerVisitBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerVisitBookApplication.class, args);
    }

}
