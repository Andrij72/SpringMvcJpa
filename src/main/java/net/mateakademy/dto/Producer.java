package net.mateakademy.dto;

import net.mateakademy.model.ProductEntity;
import java.util.Set;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Producer {
    private UUID id;
    private String name;
    private Set<ProductEntity> product;
}
