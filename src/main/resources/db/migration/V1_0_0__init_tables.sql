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

CREATE TABLE sport_club
(
    id   BIGINT PRIMARY KEY,
    uuid VARCHAR(36) NOT NULL,
    name VARCHAR(255),
    city VARCHAR(255)
);

CREATE TABLE venue
(
    id        BIGINT PRIMARY KEY,
    uuid      VARCHAR(36) NOT NULL,
    name      VARCHAR(255),
    address   VARCHAR(255),
    latitude  DECIMAL,
    longitude DECIMAL
);

CREATE TABLE game
(
    id             BIGINT PRIMARY KEY,
    uuid           VARCHAR(36) NOT NULL,
    competition_id BIGINT,
    start_time     TIMESTAMP,
    game_number    BIGINT,
    venue_id       BIGINT,
    host_id        BIGINT,
    guest_id       BIGINT,
    FOREIGN KEY (competition_id) REFERENCES competition (id),
    FOREIGN KEY (venue_id) REFERENCES venue (id),
    FOREIGN KEY (host_id) REFERENCES sport_club (id),
    FOREIGN KEY (guest_id) REFERENCES sport_club (id)
);

CREATE TABLE unavailability_period
(
    id                BIGINT PRIMARY KEY,
    uuid              VARCHAR(36) NOT NULL,
    table_official_id BIGINT
        CONSTRAINT fk__unavailability_date__t_official REFERENCES table_official (id),
    "from"            TIMESTAMP   NOT NULL,
    until             TIMESTAMP   NOT NULL
);

CREATE TABLE assignment
(
    id                BIGINT PRIMARY KEY,
    uuid              VARCHAR(36) NOT NULL,
    acceptance_status VARCHAR(8)  NOT NULL CHECK ( acceptance_status IN ('PENDING', 'ACCEPTED', 'REJECTED') ) DEFAULT 'PENDING',
    position          VARCHAR(25) CHECK ( position IN
                                          ('SCORER', 'TIMER', 'SHOT_CLOCK_OPERATOR', 'STATISTICIAN', 'SCORER_ASSISTANT', 'STATISTICIAN_ASSISTANT_1', 'STATISTICIAN_ASSISTANT_2') ),
    table_official_id BIGINT
        CONSTRAINT fk__assignment__t_official REFERENCES table_official (id),
    game_id           BIGINT
        CONSTRAINT fk__assignment__game REFERENCES game (id)
);
