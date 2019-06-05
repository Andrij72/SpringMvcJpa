package net.mateakademy.service;

import net.mateakademy.model.UserEntity;
import net.mateakademy.model.NoEntityException;
import net.mateakademy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
@lombok.RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements BaseService<UserEntity> {
    private final UserRepository repository;

    @Override
    public void createOne(UserEntity entity) {
        repository.save(entity);
    }

    @Override
    public void updateOne(UserEntity entity) {
        repository.save(entity);
    }

    @Override
    public void deleteOneById(java.util.UUID id) {
        repository.deleteById(id);
    }

    @Override
    public UserEntity findOneById(java.util.UUID id) throws NoEntityException {
        return repository.findById(id).orElseThrow(() -> new NoEntityException(id));
    }

    public UserEntity findOneByEmail(String email) throws NoEntityException {
        return repository.findByEmail(email).orElseThrow(NoEntityException::new);
    }

    @Override
    public java.util.List<UserEntity> findAll() {
        return repository.findAll();
    }
}
