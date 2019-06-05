package net.mateakademy.repository;

import net.mateakademy.model.ProductEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, java.util.UUID> {
}
