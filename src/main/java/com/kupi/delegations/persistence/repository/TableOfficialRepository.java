package com.kupi.delegations.persistence.repository;

import com.kupi.delegations.persistence.entity.TableOfficialEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TableOfficialRepository extends JpaRepository<TableOfficialEntity, Long>, JpaSpecificationExecutor<TableOfficialEntity> {
    Optional<TableOfficialEntity> findByUuid(String uuid);

    List<TableOfficialEntity> findAll(Specification<TableOfficialEntity> specification);
}
