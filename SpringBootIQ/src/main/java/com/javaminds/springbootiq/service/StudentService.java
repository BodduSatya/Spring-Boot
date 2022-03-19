package com.javaminds.springbootiq.service;

import com.javaminds.springbootiq.modal.Course;
import com.javaminds.springbootiq.modal.Student;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class StudentService {

    private static ArrayList<Student> students = new ArrayList<>();

    static {
        Course course1 = new Course("Course1", "Spring", "10Steps", Arrays
                .asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Course course2 = new Course("Course2", "Spring MVC", "10 Examples",
                Arrays.asList("Learn Maven", "Import Project", "First Example",
                        "Second Example"));
        Course course3 = new Course("Course3", "Spring Boot", "6K Students",
                Arrays.asList("Learn Maven", "Learn Spring",
                        "Learn Spring MVC", "First Example", "Second Example"));
        Course course4 = new Course("Course4", "Maven",
                "Most popular maven course on internet!", Arrays.asList(
                "Pom.xml", "Build Life Cycle", "Parent POM",
                "Importing into Eclipse"));

        Student student1 = new Student("Student1", "Ramu",
                "Hiker, Programmer and Architect", new ArrayList<>(Arrays
                .asList(course1, course2, course3, course4)));

        Student student2 = new Student("Student2", "Raju",
                "Hiker, Programmer and Architect", new ArrayList<>(Arrays
                .asList(course1, course2, course3)));

        students.add(student1);
        students.add(student2);
    }

    public List<Student> getAllStudents(){
        return students;
    }

    public Student getStudent(String studentId){
        return students.stream().filter(s->s.getId().equalsIgnoreCase(studentId)).findAny().orElse(null);
    }

    public List<Course> getStudentCourses(String studentId){
        Student student = getStudent(studentId);
        return student!=null ? student.getCourses() : new ArrayList<>();
    }

    public Course getStudentCourse(String studentId, String courseId){
        System.out.println("studentId = " + studentId);
        System.out.println("courseId = " + courseId);
        Student student = getStudent(studentId);
        if( student==null || student.getCourses()==null)
            return new Course();
        else{
            List<Course> courses = student.getCourses();
            return courses.stream().filter(c->c.getId().equalsIgnoreCase(courseId)).findAny().orElse(new Course());
        }
    }

    private SecureRandom random = new SecureRandom();
    public Course addStudentCourse(String studentId, Course course) {
        Student student = getStudent(studentId);
        if (student == null) {
            return null;
        }

        String randomId = new BigInteger(130, random).toString(32);
        course.setId(randomId);
        student.getCourses().add(course);
        return course;
    }


}
