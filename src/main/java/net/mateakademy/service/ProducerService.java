package net.mateakademy.service;

import net.mateakademy.model.ProducerEntity;
import net.mateakademy.model.NoEntityException;
import net.mateakademy.repository.ProducerRepository;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProducerService implements BaseService<ProducerEntity> {
    private final ProducerRepository repository;

    @Override
    public void createOne(ProducerEntity entity) {
        repository.save(entity);
    }

    @Override
    public void updateOne(ProducerEntity entity) {
        repository.save(entity);
    }

    @Override
    public void deleteOneById(java.util.UUID id) {
        repository.deleteById(id);
    }

    @Override
    public ProducerEntity findOneById(java.util.UUID id) throws NoEntityException{
        return repository.findById(id).orElseThrow(() -> new NoEntityException(id));
    }

    @Override
    public java.util.List<ProducerEntity> findAll() {
        return repository.findAll();
    }
}
