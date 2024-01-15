package com.kupi.persistence.repository;

import com.kupi.persistence.entity.VenueEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VenueRepository extends JpaRepository<VenueEntity, Long> {
}
