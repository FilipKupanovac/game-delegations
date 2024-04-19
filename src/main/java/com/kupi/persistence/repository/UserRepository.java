package com.kupi.persistence.repository;

import com.kupi.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUuid(String uuid);
    Optional<UserEntity> findByEmailAndEncryptedPassword(String email, String encryptedPassword);

    boolean existsByEmailAndEncryptedPassword(String email, String encryptedPassword);
}
