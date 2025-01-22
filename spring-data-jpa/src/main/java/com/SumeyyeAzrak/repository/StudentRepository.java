package com.SumeyyeAzrak.repository;

import com.SumeyyeAzrak.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    //HQL: Sınıfın ismi ve değişken isimleri kullanılarak sorgular yazılır.
    //SQL: tablo ismi ve tablo içerisindeki kolon isimleri ile sorgular yazılır.

    @Query(value = "Select * from student", nativeQuery = true)
    List<Student> findAllStudents();

    @Query(value = "from Student s where s.id = :id")
   Optional<Student>  findStudentById(int id);

}
