package net.mateakademy.dto;

import net.mateakademy.model.ProducerEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Product {
    private UUID id;
    private String name;
    private BigDecimal price;
    private ProducerEntity producer;
}
