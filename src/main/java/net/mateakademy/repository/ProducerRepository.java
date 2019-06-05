package net.mateakademy.repository;

import net.mateakademy.model.ProducerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProducerRepository extends JpaRepository<ProducerEntity, UUID> {
}
