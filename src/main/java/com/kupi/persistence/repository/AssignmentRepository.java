package com.kupi.persistence.repository;

import com.kupi.persistence.entity.AssignmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long> {
    Optional<AssignmentEntity> findByUuid(String uuid);
}
