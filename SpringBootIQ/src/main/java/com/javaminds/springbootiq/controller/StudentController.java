package com.javaminds.springbootiq.controller;

import com.javaminds.springbootiq.modal.Course;
import com.javaminds.springbootiq.modal.Student;
import com.javaminds.springbootiq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class StudentController {

    @Autowired
    private StudentService studentService;

    //http://localhost:8080/v2/getAllStudents
    @GetMapping("/getAllStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //http://localhost:8080/getStudentCourses/Student1
    @GetMapping("/getStudentCourses/{studentId}")
    public List<Course> getStudentCourses(@PathVariable String studentId ){
        return studentService.getStudentCourses(studentId);
    }

    //http://localhost:8080/getStudentCourse/Student1/Course2
    @GetMapping("/getStudentCourse/{studentId}/{courseId}")
    public Course getStudentCourse(@PathVariable String studentId, @PathVariable String courseId ){
        return studentService.getStudentCourse(studentId, courseId);
    }

    /* http://localhost:8080/v2/addCourse/Student2
      {
            "id": "uqjr1p1kgsk07qj5ugramuk2lf",
            "name": "Docker",
            "description": "Learn Docker in 30mins",
            "steps": [
                "docker setup",
                "docker commands",
                "docker hub",
                "demo app deployment"
            ]
        }
     */
    @PostMapping("/v2/addCourse/{studentId}")
    public Course addCourse(@PathVariable String studentId, @RequestBody Course course ){
        return studentService.addStudentCourse(studentId,course);
    }


}
