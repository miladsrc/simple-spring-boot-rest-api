package com.controller;


import com.Bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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

    //Spring boot rest api with path variable
    //{id} - URL template variable
    //http://localhost:8080/students/{id}
    /*
    * to binde this url with id we need path variable annotation
    * */
    @GetMapping("/students/{id}")
    public Student studentPathVariable(@PathVariable("id") Long id){
        return new Student(id, "jack", "jackson", "jackson@gmail.com");
    }



    /*
    spring boot rest api with request parameter
    **we use query to make it unique
    http://localhost:8080/students/query?id=1
     */
    @GetMapping("/students/query")
    public Student studentRequestParameter(@RequestParam Long id){
        return new Student(id, "jack", "jackson", "jack@gmail.com ");
    }

    /*
       spring boot rest api with request parameter two
       **we use query to make it unique
       http://localhost:8080/students/query?id=1&firstName=milad&lastName=barani&email=milad@gmail.com
        */
    @GetMapping("/students/queryTwo")
    public Student studentRequestParameterTwo(@RequestParam Long id ,
                                              @RequestParam String firstName ,
                                              @RequestParam String lastName,
                                              @RequestParam String email){
        return new Student(id, firstName, lastName, email);
    }

}
