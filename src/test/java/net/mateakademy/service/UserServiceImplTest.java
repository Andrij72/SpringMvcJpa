package net.mateakademy.service;

import net.mateakademy.dto.User;
import net.mateakademy.mappers.UserMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application_test.properties")
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    private UserMapper userMapper = Mappers.getMapper(UserMapper.class);
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User()
                .setEmail("email")
                .setPassword("password")
                .setFirstName("FirstName")
                .setLastName("LastName");

        userService.createUser(user);
    }

    @Test
    public void createUser() {
        User testUser = new User()
                .setEmail("Test User")
                .setPassword("password")
                .setFirstName("FirstName")
                .setLastName("LastName");

        userService.createUser(testUser);

        assertEquals(testUser, userMapper.mapUserToUserEntity(userService.getUserById(5L)));
    }

    @Test
    public void getUserById() {
        assertEquals(user, userMapper.mapUserToUserEntity(userService.getUserById(1L)));
    }

    @Test
    public void deleteUserById() {
        userService.deleteUserById(1L);
        assertNull(userService.getUserById(1L));
    }

    @Test
    public void getAllUsers() {
        assertEquals(4, userService.getAllUsers().size());
    }

    @Test
    public void getUserByEmail() {
        User SecondTestUser = new User()
                .setEmail("second@gmail.com")
                .setPassword("password")
                .setFirstName("FirstName")
                .setLastName("LastName");

        userService.createUser(SecondTestUser);
        assertEquals(SecondTestUser, userMapper.mapUserToUserEntity(userService.getUserByEmail("second@gmail.com")));
    }
}
