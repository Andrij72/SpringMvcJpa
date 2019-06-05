package net.mateakademy.model;

import static javax.persistence.GenerationType.IDENTITY;

@lombok.Getter
@lombok.Setter
@javax.persistence.Entity
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.experimental.Accessors(chain = true)
@javax.persistence.Table(name = "roles")
public class RoleEntity {

    @javax.persistence.Id
    @javax.persistence.GeneratedValue(strategy = IDENTITY)
    @javax.persistence.Column(name = "role_id")
    private java.util.UUID id;

    @javax.persistence.Column(name = "name", nullable = false)
    private String name;
}
