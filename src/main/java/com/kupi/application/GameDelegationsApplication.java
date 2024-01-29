package com.kupi.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameDelegationsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GameDelegationsApplication.class, args);
    }
    // TODO
    //  - make database critical operations like delete secured with additional confirmation layer - this is for FE idea
    //  - provide functionality for table officials to set unavailability periods - new api
    //  - provide functionality to display table official's games
    //  - provide functionality for table official to accept or reject game. Optional - add reason text field,
    //  ,
    //  - optional:
    //     - make table official reports to be done by commissioner
    //     - enable specific user permissions profile for table officials admin who delegates officials and make it
    //            available to assign from one to another user, only existing delegate can assign to another user
    //     - based on official's scores by commissioner, make color labels to visualize official performance,
}