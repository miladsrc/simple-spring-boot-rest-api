package spring.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import spring.Bean.Student;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "student")
public class StudentController {


    //http://localhost:8080/student-get
    @GetMapping("/student-get")
//    @ResponseStatus(HttpServletResponse.Ok)
    public ResponseEntity<Student> getStudent() {
        Student student = Student.builder()
                .firstName("jackson")
                .lastName("jackson")
                .email("jackson@gmail.com")
                .build();
// 1->       return new ResponseEntity<>(student, HttpStatus.OK);
// 2->      return ResponseEntity.ok(Student);
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(student);
    }

    //http://localhost:8080/student
    @GetMapping
    public ResponseEntity<List<Student>> getStudentList() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(2L, "jack", "jackson", "jackson@gmail.com"));
        students.add(new Student(3L, "ram", "jack", "jackson@gmail.com"));
        students.add(new Student(3L, "ram", "jack", "jackson@gmail.com"));
        students.add(new Student(3L, "ram", "jack", "jackson@gmail.com"));

//        return ResponseEntity.ok(students);
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(students);
    }

    //Spring boot rest api with path variable
    //{id} - URL template variable
    //http://localhost:8080/students/{id}
    /*
    * to binde this url with id we need path variable annotation
    * */
    @GetMapping("students/{id}")
    public Student studentPathVariable(@PathVariable("id") Long id){
        return new Student(id, "jack", "jackson", "jackson@gmail.com");
    }



    /*
    spring boot rest api with request parameter
    **we use query to make it unique
    http://localhost:8080/students/query?id=1
     */
    @GetMapping("students/query")
    public Student studentRequestParameter(@RequestParam Long id){
        return new Student(id, "jack", "jackson", "jack@gmail.com ");
    }


    /*
       spring boot rest api with request parameter two
       **we use query to make it unique
       http://localhost:8080/students/query?id=1&firstName=milad&lastName=barani&email=milad@gmail.com
        */
    @GetMapping("students/queryTwo")
    public Student studentRequestParameterTwo(@RequestParam Long id ,
                                              @RequestParam String firstName ,
                                              @RequestParam String lastName,
                                              @RequestParam String email){
        return new Student(id, firstName, lastName, email);
    }





    //Spring boot rest api that handel post request - create new resource
    //@PostMapping and @RequestBody
    @PostMapping("create")
    //must return 200 status that means created
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println(student.getId()+":"+student.getFirstName()+" "+student.getLastName()+" "+student.getEmail());
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }





    //Spring boot rest api that handel put request - updating existing resources
    @PutMapping("{id}/updates")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student,@PathVariable("id") Long studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return ResponseEntity.ok(student);
    }




    //Spring boot rest api that handel delete requests = delete existing resource
    @DeleteMapping("student/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
        System.out.println(studentId+" deleted");
        return ResponseEntity.ok("student deleted successfully!");
    }


}
