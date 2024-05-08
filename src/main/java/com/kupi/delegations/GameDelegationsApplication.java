package com.kupi.delegations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GameDelegationsApplication {
    public static void main(String[] args) {
        SpringApplication.run(GameDelegationsApplication.class, args);
    }
    // TODO
    //  - make database critical operations like delete secured with additional confirmation layer - this is for FE idea
    //  - CRITICAL: enable security, JWT tokens, refresh, keycloak
    //  - implement assigning officials to the game based on unavailability, do not assign people if they are unavailable 1:30 before and 2:30 after game start
    //  - provide functionality to display table official's games
    //  - provide functionality for table official to accept or reject game. Optional - add reason text field
    //  - CREATE assignment table, which would store game_id, official_id, position, acceptedStatus (Y/N), description?,
    //  ,
    //  - optional:
    //     - make table official reports to be done by commissioner
    //     - enable specific user permissions profile for table officials admin who delegates officials and make it
    //            available to assign from one to another user, only existing delegate can assign to another user
    //     - based on official's scores by commissioner, make color labels to visualize official performance,
}