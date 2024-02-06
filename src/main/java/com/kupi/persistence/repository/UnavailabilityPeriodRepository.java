package com.kupi.persistence.repository;

import com.kupi.persistence.entity.UnavailabilityPeriodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnavailabilityPeriodRepository extends JpaRepository<UnavailabilityPeriodEntity, Long> {
    Optional<UnavailabilityPeriodEntity> findByUuid(String uuid);
}
