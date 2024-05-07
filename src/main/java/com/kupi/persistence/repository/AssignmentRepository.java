package com.kupi.persistence.repository;

import com.kupi.persistence.entity.AssignmentEntity;
import com.kupi.persistence.entity.GameEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssignmentRepository extends JpaRepository<AssignmentEntity, Long> {
    Optional<AssignmentEntity> findByUuid(String uuid);
    List<AssignmentEntity> findAllByGame(GameEntity gameEntity);
    Page<AssignmentEntity> findAllByTableOfficialUuid(String uuid, Pageable pageable);
}
