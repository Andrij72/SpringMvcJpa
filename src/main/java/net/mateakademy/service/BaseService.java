package net.mateakademy.service;

import net.mateakademy.model.NoEntityException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface BaseService<T> {
    void createOne(T entity);
    void updateOne(T entity);
    void deleteOneById(java.util.UUID id);
    T findOneById(java.util.UUID id) throws NoEntityException;
    List<T> findAll();
}
