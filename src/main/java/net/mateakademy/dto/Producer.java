package net.mateakademy.dto;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.experimental.Accessors(chain = true)
public class Producer {
        private java.util.UUID id;
        private String name;
        private java.util.Set<net.mateakademy.model.ProductEntity> product;
    }
