package net.mateakademy.mapping;

import net.mateakademy.dto.Role;
import net.mateakademy.model.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public Role mapRoleEntityToRole(RoleEntity entity){
        return new Role()
                .setId(entity.getId())
                .setName(entity.getName());
    }

    public java.util.List<Role> mapRoleEntitiesToRoles(java.util.List<RoleEntity> entities){
        return entities.stream()
                .map(this::mapRoleEntityToRole)
                .collect(java.util.stream.Collectors.toList());
    }

    public RoleEntity mapRoleToRoleEntity(Role role){
        RoleEntity entity = new RoleEntity()
                .setName(role.getName());
        entity.setId(role.getId());
        return entity;
    }
}
