package com.SumeyyeAzrak.services.impl;

import com.SumeyyeAzrak.dto.DtoStudent;
import com.SumeyyeAzrak.dto.DtoStudentIU;
import com.SumeyyeAzrak.entites.Student;
import com.SumeyyeAzrak.repository.StudentRepository;
import com.SumeyyeAzrak.services.IStudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Transactional
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {

        DtoStudent response = new DtoStudent();
        Student student = new Student();
        BeanUtils.copyProperties(dtoStudentIU,student);

        Student dbStudent = studentRepository.save(student);
        BeanUtils.copyProperties(dbStudent, response);


            return response;

        }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<DtoStudent> dtoList = new ArrayList<>();

        List<Student> studentList = studentRepository.findAllStudents();
        for (Student student : studentList) {
            DtoStudent dto = new DtoStudent();
            BeanUtils.copyProperties(student,dto);
            dtoList.add(dto);

        }
        return dtoList;
    }

    @Override
    public DtoStudent getStudentById(int id) {
        DtoStudent dto = new DtoStudent();
//        Optional<Student> optional = studentRepository.findById(id);

         Optional<Student> optional = studentRepository.findStudentById(id);
      if (optional.isPresent()){
          Student dbStudent = optional.get();

          BeanUtils.copyProperties(dbStudent, dto);

      }
        return dto;
    }


    @Override
    public void deleteStudent(int id) {
        Optional<Student> optional = studentRepository.findById(id);


        if(optional.isPresent()){
            studentRepository.delete(optional.get());
        }
    }



    @Override
    public DtoStudent updateStudent(int id, DtoStudentIU dtoStudentIU) {

       DtoStudent dto = new DtoStudent();

       Optional<Student> optional = studentRepository.findById(id);
       if (optional.isPresent()){
           Student dbStudent = optional.get();

           dbStudent.setFirstName(dtoStudentIU.getFirstName());
           dbStudent.setLastName(dtoStudentIU.getLastName());
           dbStudent.setBirthOfDate(dtoStudentIU.getBirthOfDate());

           Student updateStudent = studentRepository.save(dbStudent);

           BeanUtils.copyProperties(updateStudent, dto);
           return dto;
       }
       return null;
    }


}


