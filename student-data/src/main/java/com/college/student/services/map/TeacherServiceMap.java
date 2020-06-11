package com.college.student.services.map;

import com.college.student.model.Teacher;
import com.college.student.services.TeacherService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class TeacherServiceMap extends AbstractMapService<Teacher, Long> implements TeacherService
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
        return super.save(object);
    }

    @Override
    public void delete(Teacher object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Teacher findByLastName(String lastName) {
        return null;
    }
}
