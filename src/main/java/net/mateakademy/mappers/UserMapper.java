package net.mateakademy.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import net.mateakademy.dto.User;
import net.mateakademy.entities.UserEntity;
import java.util.List;

@Mapper
public interface UserMapper {
    UserEntity mapUserToUserEntity(User user);

    @Mapping(target = "id", source = "id")
    User mapUserEntityToUser(UserEntity userEntity);

    List<User> mapUserEntityListToUserList(List<UserEntity> userEntities);
}
