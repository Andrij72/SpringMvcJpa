package net.mateakademy.dto;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.experimental.Accessors(chain = true)
public class Product {
    private java.util.UUID id;
    private String name;
    private java.math.BigDecimal price;
    private net.mateakademy.model.ProducerEntity producer;
}
