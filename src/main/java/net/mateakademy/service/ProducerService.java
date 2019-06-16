package net.mateakademy.service;

import net.mateakademy.dto.Producer;
import java.util.List;

public interface ProducerService {
    void createProducer(Producer producer);

    Producer getProducerById(Long id);

    void deleteProducerById(Long id);

    List<Producer> getAllProducers();

    Producer getProducerByName(String name);
}
