package net.mateakademy.repository;

import net.mateakademy.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface UserRepository extends JpaRepository<UserEntity, java.util.UUID> {
    java.util.Optional<UserEntity> findByEmail(String email);
}
