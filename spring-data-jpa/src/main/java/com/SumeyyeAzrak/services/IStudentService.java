package com.SumeyyeAzrak.services;

import com.SumeyyeAzrak.entites.Student;

import java.util.List;

public interface IStudentService {

    public Student saveStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentById(int id);
}
