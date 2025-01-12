package com.SumeyyeAzrak.services;

import com.SumeyyeAzrak.dto.DtoStudent;
import com.SumeyyeAzrak.dto.DtoStudentIU;
import com.SumeyyeAzrak.entites.Student;

import java.util.List;

public interface IStudentService {

    public DtoStudent saveStudent(DtoStudentIU student);

    public List<DtoStudent> getAllStudents();

    public DtoStudent getStudentById(int id);

   public void deleteStudent(int id);

    public DtoStudent updateStudent(int id, DtoStudentIU dtoStudentIU);
}
