package net.mateakademy.service;

import java.util.List;
import lombok.AllArgsConstructor;
import net.mateakademy.dto.Producer;
import net.mateakademy.mappers.ProducerMapper;
import net.mateakademy.repository.ProducerRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerServiceImpl implements ProducerService {

    private final ProducerRepository repository;
    private final ProducerMapper mapper = Mappers.getMapper(ProducerMapper.class);

    @Override
    public void createProducer(Producer producer) {
        repository.save(mapper.mapProducerToProducerEntity(producer));
    }

    @Override
    public Producer getProducerById(Long id) {
        return mapper.mapProducerEntityToProducer(repository.findById(id).orElse(null));
    }

    @Override
    public void deleteProducerById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Producer> getAllProducers() {
        return mapper.mapProducerEntityListToProducerList(repository.findAll());
    }

    @Override
    public Producer getProducerByName(String name) {
        return mapper.mapProducerEntityToProducer(repository.findByName(name).orElse(null));
    }
}
