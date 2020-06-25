package com.college.student.repositories;

import com.college.student.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long>
{
    Student findByLastName(String lastName);

    List<Student> findAllByLastNameLike(String lastName);
}
