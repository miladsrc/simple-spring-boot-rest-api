package spring.Bean;


import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Student {
    Long id;
    String firstName;
    String lastName;
    String email;
}
