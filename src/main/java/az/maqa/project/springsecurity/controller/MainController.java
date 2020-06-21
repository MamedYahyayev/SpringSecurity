package az.maqa.project.springsecurity.controller;


import az.maqa.project.springsecurity.model.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class MainController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Arif"),
            new Student(2, "Akif"),
            new Student(3, "Samir"),
            new Student(4, "Arife")
    );

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS
                .stream()
                .filter(student -> studentId.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist"));
    }

    @GetMapping
    public List<Student> getStudentList() {
        return STUDENTS;
    }


}
