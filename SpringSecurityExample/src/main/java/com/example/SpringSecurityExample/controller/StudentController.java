package com.example.SpringSecurityExample.controller;

import com.example.SpringSecurityExample.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  private final List<Student> students = new ArrayList<>(List.of(
      new Student(1 , "Student 1", 4),
      new Student(2 , "Student 2", 3),
      new Student(3 , "Student 3", 5),
      new Student(4 , "Student 4", 5),
      new Student(5 , "Student 5", 2)
  ));


  @GetMapping("/students")
  public List<Student> getStudents() {
    return students;
  }

  @GetMapping("/csrf-token")
  public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest) {
    return (CsrfToken) httpServletRequest.getAttribute("_csrf");
  }

  @PostMapping
  public Student createStudent(@RequestBody Student student) {
    students.add(student);
    return student;
  }

}
