package com.college.student.repositories;

import com.college.student.model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long>
{
    Student findByLastName(String lastName);
}
