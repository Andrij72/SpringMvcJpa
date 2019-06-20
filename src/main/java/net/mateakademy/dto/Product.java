package net.mateakademy.dto;

import net.mateakademy.entities.ProducerEntity;
import  net.mateakademy.entities.ProductEntity;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Product {
    private Long id;
    private UUID uuid;
    private String name;
    private BigDecimal price;
    private ProducerEntity producer;
    private String producerName;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 2;

        return prime * result + (name == null ? 0 : name.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ProductEntity) {

            ProductEntity productEntity = (ProductEntity) obj;

            if (this.name.equals(productEntity.getName()) &&
                    this.price.equals(productEntity.getPrice()) &&
                    this.producer.equals(productEntity.getProducer())) {
                return true;
            }
        }
        return false;
    }
}
