package net.mateakademy.service;

import net.mateakademy.entities.RoleEntity;
import java.util.List;

public interface RoleService {

    void createRoleEntity(RoleEntity roleEntity);

    List<RoleEntity> getRoleEntities();

    RoleEntity getRoleById(Long id);
}
