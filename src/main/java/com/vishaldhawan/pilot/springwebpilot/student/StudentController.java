package com.vishaldhawan.pilot.springwebpilot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@Valid @RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @GetMapping(path = "{studentId}")
    public EntityModel<Student> getStudentById(@PathVariable("studentId") Long studentId) {
        Student student = studentService.getStudentById(studentId);
        EntityModel<Student> entityModelStudent = EntityModel.of(student);
        WebMvcLinkBuilder linkBuilder = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getStudents());
        entityModelStudent.add(linkBuilder.withRel("all-students"));
        return entityModelStudent;
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email
                              ) {
        studentService.updateStudent(studentId, name, email);
    }
}
