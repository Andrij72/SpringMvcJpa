package net.mateakademy.service;

import net.mateakademy.model.ProductEntity;
import net.mateakademy.model.NoEntityException;
import net.mateakademy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductService implements BaseService<ProductEntity> {
    private final ProductRepository repository;

    @Override
    public void createOne(ProductEntity entity) {
        repository.save(entity);
    }

    @Override
    public void updateOne(ProductEntity entity) {
        repository.save(entity);
    }

    @Override
    public void deleteOneById(java.util.UUID id) {
        repository.deleteById(id);
    }

    @Override
    public ProductEntity findOneById(java.util.UUID id) throws NoEntityException {
        return repository.findById(id).orElseThrow(() -> new NoEntityException(id));
    }

    @Override
    public java.util.List<ProductEntity> findAll() {
        return repository.findAll();
    }
}
