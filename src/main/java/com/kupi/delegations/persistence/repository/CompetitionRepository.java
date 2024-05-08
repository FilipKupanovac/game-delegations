package com.kupi.delegations.persistence.repository;

import com.kupi.delegations.persistence.entity.CompetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompetitionRepository extends JpaRepository<CompetitionEntity, Long> {
    Optional<CompetitionEntity> findByUuid(String uuid);
}
