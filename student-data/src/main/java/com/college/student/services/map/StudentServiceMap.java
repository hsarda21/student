package com.college.student.services.map;

import com.college.student.model.Student;
import com.college.student.services.CrudService;

import java.util.Set;

public class StudentServiceMap extends AbstractMapService<Student, Long> implements CrudService<Student, Long>
{
    @Override
    public Set<Student> findAll() {
        return super.findAll();
    }

    @Override
    public Student findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Student save(Student object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Student object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
