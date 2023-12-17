package com.kupi.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UUID;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @UUID(version = 4)
    @Column(name = "uuid")
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "competition")
    private CompetitionEntity competition;

    @Column(name = "game_number")
    private Integer gameNumber;

    @Column(name = "start_time")
    private Instant startTime;

    @ManyToOne
    @JoinColumn(name = "venue")
    private VenueEntity venue;

    @ManyToOne
    @JoinColumn(name = "host")
    private SportsClubEntity host;

    @ManyToOne
    @JoinColumn(name = "guest")
    private SportsClubEntity guest;

    @ManyToOne
    @JoinColumn(name = "scorer")
    private TableOfficialEntity scorer;

    @ManyToOne
    @JoinColumn(name = "timer")
    private TableOfficialEntity timer;

    @ManyToOne
    @JoinColumn(name = "shot_clock")
    private TableOfficialEntity shotClockOperator;

    @ManyToOne
    @JoinColumn(name = "statistician")
    private TableOfficialEntity statistician;

    @ManyToOne
    @JoinColumn(name = "statistician_assistant")
    private TableOfficialEntity statisticianAssistant;

}
