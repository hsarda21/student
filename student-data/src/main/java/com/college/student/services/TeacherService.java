package com.college.student.services;

import com.college.student.model.Student;
import com.college.student.model.Teacher;

import java.util.Set;

public interface TeacherService
{
    Teacher findByLastName(String lastName);

    Teacher findById(Long id);

    Teacher save(Teacher teacher);

    Set<Teacher> findAll();
}
