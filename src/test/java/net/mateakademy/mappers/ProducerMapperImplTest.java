package net.mateakademy.mappers;

import net.mateakademy.dto.Producer;
import net.mateakademy.entities.ProducerEntity;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class ProducerMapperImplTest {

    private ProducerMapper mapper = Mappers.getMapper(ProducerMapper.class);

    @Test
    public void mapProducerToProducerEntity() {
        Producer producer = new Producer()
                .setName("Apple");

        ProducerEntity producerEntity = mapper.mapProducerToProducerEntity(producer);
        assertEquals(producer, producerEntity);
    }

    @Test
    public void mapProducerEntityToProducer() {
        ProducerEntity producerEntity = new ProducerEntity()
                .setName("Apple");

        Producer producer = mapper.mapProducerEntityToProducer(producerEntity);
        assertEquals(producer, producerEntity);
    }

    @Test
    public void mapProducerEntityListToProducerList() {
        List<ProducerEntity> producerEntities = new ArrayList<>();

        ProducerEntity producerEntity = new ProducerEntity()
                .setName("Apple");
        ProducerEntity producerEntitySecond = new ProducerEntity()
                .setName("HUAWEY");

        producerEntities.add(producerEntity);
        producerEntities.add(producerEntitySecond);

        List<Producer> producers = mapper.mapProducerEntityListToProducerList(producerEntities);

        assertThat("Not equal list",producers, is(producerEntities));
    }

    @Test
    public void mapProducerToProducerEntityWithNullArgument() {
        ProducerEntity producerEntity = mapper.mapProducerToProducerEntity(null);
        assertNull(producerEntity);
    }

    @Test
    public void mapProducerEntityToProducerWithNullArgument() {
        Producer producer = mapper.mapProducerEntityToProducer(null);
        assertNull(producer);
    }

    @Test
    public void mapProducerEntityListToProducerListWithNullArgument() {
        List<Producer> producers = mapper.mapProducerEntityListToProducerList(null);
        assertNull(producers);
    }
}
