package com.SumeyyeAzrak.controller;

import com.SumeyyeAzrak.dto.DtoStudent;
import com.SumeyyeAzrak.dto.DtoStudentIU;
import com.SumeyyeAzrak.entites.Student;

import java.util.List;

public interface IStudentController {

    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);

   public List<DtoStudent> getAllStudents();

   public DtoStudent getStudentById(int id);

   public void deleteStudent(int id);

   public DtoStudent updateStudent(int id, DtoStudentIU dtoStudentIU);

}
