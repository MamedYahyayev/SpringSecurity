package az.maqa.project.springsecurity.controller;

import az.maqa.project.springsecurity.model.Student;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.el.PropertyNotFoundException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Arif"),
            new Student(2, "Akif"),
            new Student(3, "Samir"),
            new Student(4, "Arife")
    );


    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_ADMINTRAINEE')")
    public List<Student> getStudentList() {
        return STUDENTS;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('course:write')")
    public void registerNewstudent(@RequestBody Student student) {
        System.out.println(student);

    }


    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('course:write')")
    public void deleteStudent(@PathVariable("studentId") Integer id) {
        System.out.println(id);
    }


    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('course:write')")
    public void updateStudent(@RequestBody Student student, @PathVariable("studentId") Integer studentId) {
        System.out.println(student + " " + studentId);
    }

    @GetMapping(path = "{studentId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_ADMINTRAINEE' , 'ROLE_STUDENT')")
    public Student getStudentList(@PathVariable("studentId") Integer studentId) {

        return STUDENTS.stream()
                .filter(student -> studentId.equals(student.getId()))
                .findFirst()
                .orElseThrow(() -> new PropertyNotFoundException());
    }


}
