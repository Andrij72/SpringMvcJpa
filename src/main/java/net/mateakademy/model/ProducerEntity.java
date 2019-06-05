package net.mateakademy.model;


import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@javax.persistence.Entity
@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.experimental.Accessors(chain = true)
@javax.persistence.Table(name = "producers")
public class ProducerEntity {
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = IDENTITY)
    @javax.persistence.Column(name = "producer_id")
    private java.util.UUID id;

    @javax.persistence.Column(name = "name", nullable = false)
    private String name;

    @javax.persistence.ElementCollection(targetClass=ProductEntity.class)
    @javax.persistence.OneToMany(fetch = EAGER, mappedBy = "producer", cascade = javax.persistence.CascadeType.ALL)
    private java.util.Set<net.mateakademy.model.ProductEntity> products;
}
