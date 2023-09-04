package com.developez.spring.boot.api.controller;

import com.developez.spring.boot.api.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    // Ricevere uno studente
    // http://localhost:8080/student
    @GetMapping("student")
    public Student getStudent() {
        Student student = new Student(
                1,
                "John",
                "Doe"
        );
        return student;
    }

    // Ricevere una lista di studenti
    // http://localhost:8080/students
    @GetMapping
    public List<Student> getStudents() {
        List<Student> students = List.of(
                new Student(1, "John", "Doe"),
                new Student(2, "Jane", "Doe"),
                new Student(3, "Jack", "Doe")
        );
        return students;
    }

    // Ricevere uno studente con un parametro utilizzando @PathVariable
    // http://localhost:8080/students/1/John/Doe
    @GetMapping("{id}/{first-name}/{last-name}")
    public Student getStudentById(@PathVariable("id") int studentId,
                                  @PathVariable("first-name") String firstName,
                                  @PathVariable("last-name") String lastName) {
        Student student = new Student(
                studentId,
                firstName,
                lastName
        );
        return student;
    }

    // Ricevere uno studente con dei parametri utilizzando @RequestParam
    // http://localhost:8080/students/query?studentId=1&firstName=John&lastName=Doe
    @GetMapping("query")
    public Student getStudentParamsById(
            @RequestParam int studentId,
            @RequestParam String firstName,
            @RequestParam String lastName
    ) {
        Student student = new Student(
                studentId,
                firstName,
                lastName
        );
        return student;
    }

    // Creare uno studente utilizzando @RequestBody
    // http://localhost:8080/students/create
    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }


    // Aggiornare uno studente utilizzando @RequestBody
    // http://localhost:8080/students/update
    @PutMapping("{id}/update")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId) {
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    // Eliminare uno studente utilizzando @PathVariable
    // http://localhost:8080/students/1/delete
    @DeleteMapping("{id}/delete")
    public void deleteStudent(@PathVariable("id") int studentId) {
        System.out.println("Student with id " + studentId + " deleted");
    }
}
