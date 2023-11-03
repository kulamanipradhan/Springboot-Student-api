package com.example.kulu.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
       Optional<Student> studentByEmail = studentRepository
               .findStudentByEmail(student.getEmail());
       if(studentByEmail.isPresent())
       {
           throw new IllegalStateException("Email is already present");
       }
       studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists)
        {
            throw new IllegalStateException("Student with id" +studentId+ "not exist");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
       Student student= studentRepository.findById(studentId)
               .orElseThrow(()-> new IllegalStateException("Student with id "+studentId+" Does exist"));
       if(name != null &&
       name.length() > 0 && !Objects.equals(student.getName(),name))
       {
           student.setName(name);
       }
        if(email != null &&
                email.length() > 0 && !Objects.equals(student.getEmail(),email))
        {
            Optional<Student> studentByEmail = studentRepository.findStudentByEmail(email);
            if(studentByEmail.isPresent())
            {
                throw  new IllegalStateException("Email is taken");
            }
            student.setEmail(email);
        }
    }
}
