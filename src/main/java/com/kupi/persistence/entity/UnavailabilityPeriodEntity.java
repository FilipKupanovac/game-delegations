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
@Table(name = "unavailability_period")
public class UnavailabilityPeriodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @UUID(version = 4)
    @Column(name = "uuid")
    private String uuid;

    @ManyToOne
    @JoinColumn(name = "table_official_id")
    private TableOfficialEntity tableOfficial;

    @Column(name = "from")
    private Instant from;

    @Column(name = "until")
    private Instant until;
}
