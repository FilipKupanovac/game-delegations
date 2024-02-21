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

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "game")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    private CompetitionEntity competition;

    @Column(name = "game_number")
    private Integer gameNumber;

    @Column(name = "start_time")
    private Instant startTime;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private VenueEntity venue;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private SportClubEntity host;

    @ManyToOne
    @JoinColumn(name = "guest_id")
    private SportClubEntity guest;
}
