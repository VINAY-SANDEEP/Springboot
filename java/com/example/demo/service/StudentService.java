package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAllStudents() {
        return repo.findAll();
    }

    public Student getStudentById(String id) {
        return repo.findById(id).orElse(null);
    }

    public Student createStudent(Student student) {
        return repo.save(student);
    }

    public Student updateStudent(String id, Student student) {
        student.setId(id);
        return repo.save(student);
    }

    public void deleteStudent(String id) {
        repo.deleteById(id);
    }
}
