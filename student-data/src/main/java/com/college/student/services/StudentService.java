package com.college.student.services;

import com.college.student.model.Student;

import java.util.List;
import java.util.Set;

public interface StudentService extends CrudService<Student, Long>
{
    Student findByLastName(String lastName);

    List<Student> findAllByLastNameLike(String lastName);
}
