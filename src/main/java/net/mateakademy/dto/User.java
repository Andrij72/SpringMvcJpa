package net.mateakademy.dto;

import net.mateakademy.model.RoleEntity;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.experimental.Accessors(chain = true)
public class User {
    private java.util.UUID id;
    private String firstName;
    private String lastName;
    private String password;
    private RoleEntity role;
    private String email;
}
