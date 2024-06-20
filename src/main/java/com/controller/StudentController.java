package com.controller;


import com.Bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {


    //http://localhost:8080/student-get
    @GetMapping("/student-get")
    public Student getStudent() {
        Student student = Student.builder()
                .firstName("jackson")
                .lastName("jackson")
                .email("jackson@gmail.com")
                .build();
        return student;
    }

    //http://localhost:8080/student
    @GetMapping("/student")
    public List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2L, "jack", "jackson", "jackson@gmail.com"));
        students.add(new Student(3L, "ram", "jack", "jackson@gmail.com"));
        students.add(new Student(3L, "ram", "jack", "jackson@gmail.com"));
        students.add(new Student(3L, "ram", "jack", "jackson@gmail.com"));
        return students;
    }

}
