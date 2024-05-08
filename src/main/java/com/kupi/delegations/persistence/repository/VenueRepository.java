package com.kupi.delegations.persistence.repository;

import com.kupi.delegations.persistence.entity.VenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VenueRepository extends JpaRepository<VenueEntity, Long> {
    Optional<VenueEntity> findByUuid(String uuid);
}
