package com.kupi.persistence.entity;

import com.kupi.persistence.type.AcceptanceStatus;
import com.kupi.persistence.type.TableOfficialPosition;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "assignment")
public class AssignmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "acceptance_status")
    @Enumerated(value = EnumType.STRING)
    private AcceptanceStatus acceptanceStatus;

    @Column(name = "position")
    @Enumerated(value = EnumType.STRING)
    private TableOfficialPosition position;

    @ManyToOne
    @JoinColumn(name = "table_official_id")
    private TableOfficialEntity tableOfficial;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private GameEntity game;
}
