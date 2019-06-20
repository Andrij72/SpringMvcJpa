package net.mateakademy.entities;

import net.mateakademy.listener.UuidEntityListener;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
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
@MappedSuperclass
@EntityListeners(value = UuidEntityListener.class)
public class UuidEntity extends BaseEntity{

    @Column(name = "uuid")
    private UUID uuid;
}
