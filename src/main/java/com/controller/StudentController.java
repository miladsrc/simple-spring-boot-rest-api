package com.controller;


import com.Bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {


    //http://localhost:8080/student-get
    @GetMapping("/student-get")
    public Student getStudent(){
        Student student = Student.builder()
                .firstName("jackson")
                .lastName("jackson")
                .email("jackson@gmail.com")
                .build();

        return student;
    }


}
