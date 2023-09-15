package com.crud.mahasiswa.demo.repository;

/**
 * @author muhammad.khadafi
 */


import com.crud.mahasiswa.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}

