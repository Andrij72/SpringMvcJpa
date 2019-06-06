package net.mateakademy.dto;

import net.mateakademy.model.RoleEntity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String password;
    private RoleEntity role;
    private String email;
}
