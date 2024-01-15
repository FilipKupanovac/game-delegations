package com.kupi.persistence.repository;

import com.kupi.persistence.entity.CompetitionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<CompetitionEntity, Long> {
}
