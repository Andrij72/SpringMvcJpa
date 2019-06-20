package net.mateakademy.entities;

import java.util.Set;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "producers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ProducerEntity extends UuidEntity{

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "producer", fetch = FetchType.EAGER)
    private Set<ProductEntity> products;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 2;

        return prime * result + (name == null ? 0 : name.hashCode());
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof ProducerEntity) {

            ProducerEntity producerEntity = (ProducerEntity) obj;

            if (name.equals(producerEntity.getName())) {
                return true;
            }
        }
        return false;
    }
}
