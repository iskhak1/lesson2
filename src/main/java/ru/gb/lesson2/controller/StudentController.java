package ru.gb.lesson2.controller;

import ch.qos.logback.core.net.server.ServerRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.lesson2.Student;
import ru.gb.lesson2.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/name",method = RequestMethod.GET)
    public ResponseEntity<Student> searchStudent(@PathVariable String name) {
        return new ResponseEntity<>(studentService.searchStudent(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@RequestBody Long id){
        return new ResponseEntity<>(studentService.deleteStudents(id),HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return new ResponseEntity<>(studentService.getStudent(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/name",method = RequestMethod.GET)
    public ResponseEntity<List> getStudentsByGroup(String name){
        return new ResponseEntity<>(studentService.getAllStudentsByGroup(name),HttpStatus.OK);
    }

}
