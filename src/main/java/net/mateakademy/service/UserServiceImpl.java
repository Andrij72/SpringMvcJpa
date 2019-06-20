package net.mateakademy.service;

import java.util.List;
import lombok.AllArgsConstructor;
import net.mateakademy.dto.User;
import net.mateakademy.mappers.UserMapper;
import net.mateakademy.repository.UserRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper mapper = Mappers.getMapper(UserMapper.class);

    @Override
    public void createUser(User user) {
        repository.save(mapper.mapUserToUserEntity(user));
    }

    @Override
    public User getUserById(Long id) {
        return mapper.mapUserEntityToUser(repository.findById(id).orElse(null));
    }

    @Override
    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return mapper.mapUserEntityListToUserList(repository.findAll());
    }

    @Override
    public User getUserByEmail(String email) {
        return mapper.mapUserEntityToUser(repository.findByEmail(email).orElse(null));
    }
}
