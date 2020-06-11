package com.college.student.services.map;

import com.college.student.model.Student;
import com.college.student.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentServiceMap extends AbstractMapService<Student, Long> implements StudentService
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
        return super.save(object);
    }

    @Override
    public void delete(Student object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Student findByLastName(String lastName) {
        return null;
    }
}
