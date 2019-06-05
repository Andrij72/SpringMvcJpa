package net.mateakademy.dto;

@lombok.Getter
@lombok.Setter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@lombok.experimental.Accessors(chain = true)
public class Role {
    private java.util.UUID id;
    private String name;
}
