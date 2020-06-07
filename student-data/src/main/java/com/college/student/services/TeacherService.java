package com.college.student.services;

import com.college.student.model.Student;
import com.college.student.model.Teacher;

import java.util.Set;

public interface TeacherService extends CrudService<Teacher, Long>
{
    Teacher findByLastName(String lastName);
}
