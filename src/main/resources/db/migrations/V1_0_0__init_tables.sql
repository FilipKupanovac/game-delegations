CREATE TABLE competition
(
    id     BIGINT PRIMARY KEY,
    uuid   VARCHAR(36) NOT NULL,
    name   VARCHAR(255),
    season VARCHAR(255)
);

CREATE TABLE table_official
(
    id         BIGINT PRIMARY KEY,
    uuid       VARCHAR(36) NOT NULL,
    first_name VARCHAR(255),
    last_name  VARCHAR(255)
);

CREATE TABLE sports_club
(
    id   BIGINT PRIMARY KEY,
    uuid VARCHAR(36) NOT NULL,
    name VARCHAR(255),
    city VARCHAR(255)
);

CREATE TABLE venue
(
    id      BIGINT PRIMARY KEY,
    uuid    VARCHAR(36) NOT NULL,
    name    VARCHAR(255),
    address VARCHAR(255),
    latitude DOUBLE,
    longitude DOUBLE
);

CREATE TABLE game
(
    id                        BIGINT PRIMARY KEY,
    uuid                      VARCHAR(36) NOT NULL,
    competition_id            BIGINT,
    start_time                TIMESTAMP,
    game_number               BIGINT,
    venue_id                  BIGINT,
    host_id                   BIGINT,
    guest_id                  BIGINT,
    scorer_id                 BIGINT,
    timer_id                  BIGINT,
    shot_clock_id             BIGINT,
    statistician_id           BIGINT,
    statistician_assistant_id BIGINT,
    FOREIGN KEY (competition_id) REFERENCES competition (id),
    FOREIGN KEY (venue_id) REFERENCES venue (id),
    FOREIGN KEY (host_id) REFERENCES sports_club (id),
    FOREIGN KEY (guest_id) REFERENCES sports_club (id),
    FOREIGN KEY (scorer_id) REFERENCES table_official (id),
    FOREIGN KEY (timer_id) REFERENCES table_official (id),
    FOREIGN KEY (shot_clock_id) REFERENCES table_official (id),
    FOREIGN KEY (statistician_id) REFERENCES table_official (id),
    FOREIGN KEY (statistician_assistant_id) REFERENCES table_official (id)
);
