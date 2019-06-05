package net.mateakademy.mapping;


import net.mateakademy.dto.Producer;
import net.mateakademy.model.ProducerEntity;
import org.springframework.stereotype.Component;

@Component
public class ProducerMapper {

    public Producer mapProducerEntityToProducer(ProducerEntity entity) {
        return new Producer()
                .setId(entity.getId())
                .setName(entity.getName())
                .setProducts(entity.getProducts());
    }

    public java.util.List<Producer> mapProducerEntitiesToProducers(java.util.List<ProducerEntity> entities) {
        return entities.stream()
                .map(this::mapProducerEntityToProducer)
                .collect(java.util.stream.Collectors.toList());
    }

    public ProducerEntity mapProducerToProducerEntity(Producer producer) {
        ProducerEntity entity = new ProducerEntity()
                .setName(producer.getName())
                .setProducts(producer.getProducts());
        entity.setId(producer.getId());
        return entity;
    }
}
