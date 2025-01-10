package com.SumeyyeAzrak.controller;

import com.SumeyyeAzrak.entites.Student;

import java.util.List;

public interface IStudentController {

    public Student saveStudent(Student student);

   public List<Student> getAllStudents();

   public Student getStudentById(int id);

}
