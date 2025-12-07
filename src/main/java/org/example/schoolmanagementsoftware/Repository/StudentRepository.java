package org.example.schoolmanagementsoftware.Repository;

import org.example.schoolmanagementsoftware.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findStudentByID(Integer id);
}
