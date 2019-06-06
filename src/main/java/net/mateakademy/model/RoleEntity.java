package net.mateakademy.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "role_id")
    private UUID id;

    @javax.persistence.Column(name = "name", nullable = false)
    private String name;
}
