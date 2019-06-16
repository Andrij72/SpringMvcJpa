package net.mateakademy.service;

import net.mateakademy.entities.RoleEntity;
import net.mateakademy.repository.RoleRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;

    @Override
    public void createRoleEntity(RoleEntity roleEntity) {
        repository.save(roleEntity);
    }

    @Override
    public List<RoleEntity> getRoleEntities() {
        return repository.findAll();
    }

    @Override
    public RoleEntity getRoleById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
