package ru.gb.lesson2.service;

import org.springframework.stereotype.Service;
import ru.gb.lesson2.Student;

import java.util.ArrayList;
import java.util.List;

/*
1 GET /student/{id} - получить студента по ID
   * 3.2 GET /student - получить всех студентов
   * 3.3 GET /student/search?name='studentName' - получить список студентов, чье имя содержит подстроку studentName
   * 3.4 GET /group/{groupName}/student - получить всех студентов группы
   * 3.5 POST /student - создать студента (принимает JSON) (отладиться можно с помощью Postman)
   * 3.6 DELETE /student/{id} - удалить студента
 */
@Service
public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    public Student createStudent(Student student){
        students.add(student);
        return student;
    }
    public Student getStudent(Long id){
        return students.stream().filter(i->i.getId().equals(id)).findFirst().orElse(null);
    }
    public Student searchStudent(String name){
        return students.stream().filter(n->n.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Student> getAllStudentsByGroup(String name){
        return students.stream().filter(n->n.getGroup_name().equals(name)).toList();
    }

    public ArrayList getAllStudents(){
        return students;
    }

    public Student deleteStudents(Long id){
        return students.stream().filter(i->i.getId().equals(id)).findFirst().orElse(null);
    }



}
