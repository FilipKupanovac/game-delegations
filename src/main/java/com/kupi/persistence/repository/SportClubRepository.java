package com.kupi.persistence.repository;

import com.kupi.persistence.entity.SportClubEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportClubRepository extends JpaRepository<SportClubEntity, Long> {
}
