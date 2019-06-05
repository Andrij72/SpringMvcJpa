package net.mateakademy.model;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.IDENTITY;

@lombok.Getter
@lombok.Setter
@javax.persistence.Entity
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.experimental.Accessors(chain = true)
@javax.persistence.Table(name = "users")
public class UserEntity{
    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = IDENTITY)
    @javax.persistence.Column(name = "user_id")
    private java.util.UUID id;

    @javax.persistence.Column(name = "first_name")
    private String firstName;

    @javax.persistence.Column(name = "last_name")
    private String lastName;

    @javax.persistence.Column(name = "password", nullable = false)
    private String password;


    @javax.persistence.Column(name = "email", nullable = false)
    @javax.validation.constraints.Email
    private String email;

    @javax.persistence.ManyToOne(fetch = EAGER)
    @javax.persistence.JoinColumn(name = "role_id")
    private RoleEntity role;
}
