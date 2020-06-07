package com.college.student.services.map;

import com.college.student.model.Student;
import com.college.student.model.Teacher;
import com.college.student.services.CrudService;

import java.util.Set;

public class TeacherServiceMap extends AbstractMapService<Teacher, Long> implements CrudService<Teacher, Long>
{
    @Override
    public Set<Teacher> findAll() {
        return super.findAll();
    }

    @Override
    public Teacher findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Teacher save(Teacher object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Teacher object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
