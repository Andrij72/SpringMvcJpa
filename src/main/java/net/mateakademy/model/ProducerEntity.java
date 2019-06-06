package net.mateakademy.model;

import javax.persistence.Table;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "producers")
public class ProducerEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "producer_id")
    private java.util.UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @ElementCollection(targetClass=ProductEntity.class)
    @OneToMany(fetch = EAGER, mappedBy = "producer", cascade = ALL)
    private Set<ProductEntity> products;
}
