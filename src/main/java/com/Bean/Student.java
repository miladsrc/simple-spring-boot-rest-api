package com.Bean;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@NoArgsConstructor
//@Entity
@Table(name = "students")
public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String firstName;
    String lastName;
    String email;

}
