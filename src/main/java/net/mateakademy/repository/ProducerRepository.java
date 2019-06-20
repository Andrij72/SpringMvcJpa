package net.mateakademy.repository;

import java.util.Optional;
import net.mateakademy.entities.ProducerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<ProducerEntity, Long> {
     Optional<ProducerEntity> findByName(String name);
}
