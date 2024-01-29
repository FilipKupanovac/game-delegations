package com.kupi.persistence.repository;

import com.kupi.persistence.entity.TableOfficialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TableOfficialRepository extends JpaRepository<TableOfficialEntity, Long> {
    Optional<TableOfficialEntity> findByUuid(String uuid);
}
