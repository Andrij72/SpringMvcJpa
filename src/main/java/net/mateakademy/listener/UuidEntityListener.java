package net.mateakademy.listener;

import net.mateakademy.entities.UuidEntity;
import java.util.UUID;
import javax.persistence.PrePersist;

public class UuidEntityListener {
    @PrePersist
    public void prePersist(UuidEntity uuidEntity){
        uuidEntity.setUuid(UUID.randomUUID());
    }
}
