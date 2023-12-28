package com.kupi.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameDelegationsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GameDelegationsApplication.class, args);
    }
    // TODO
    //  - add docker compose and define database
    //  - enable search by uuid, split DTO and request models for request and return type
    //  - write service javadoc for get multiple items method
    //  - make database critical operations like delete secured with additional confirmation layer
    //  - provide functionality for table officials to set unavailability periods
    //  - provide functionality to display table official's games
    //  - provide functionality for table official to accept or reject game. Optional - add reason text field,
}