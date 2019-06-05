package net.mateakademy.model;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@lombok.Getter
@lombok.Setter
@javax.persistence.Entity
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.experimental.Accessors(chain = true)
@javax.persistence.Table(name = "products")
public class ProductEntity{

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = IDENTITY)
    @javax.persistence.Column(name = "product_id")
    private java.util.UUID id;

    @javax.persistence.Column(name = "name", nullable = false)
    private String name;

    @javax.persistence.Column(name = "price")
    private java.math.BigDecimal price;

    @javax.persistence.ManyToOne(fetch = EAGER)
    @javax.persistence.JoinColumn(name = "producer_id")
    private ProducerEntity producer;
}
