package com.SumeyyeAzrak.services.impl;

import com.SumeyyeAzrak.entites.Student;
import com.SumeyyeAzrak.repository.StudentRepository;
import com.SumeyyeAzrak.services.IStudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Transactional
    public Student saveStudent(Student student) {

            return studentRepository.save(student);

        }

    @Override
    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @Override
    public Student getStudentById(int id) {
      Optional<Student> optional = studentRepository.findById(id);
      if (optional.isPresent()){
          return optional.get();
      }
        return null;
    }

    @Override
    public void deleteStudent(int id) {
        Student dbStudent = getStudentById(id);
        if(dbStudent != null){
            studentRepository.delete(dbStudent);
        }
    }


}


