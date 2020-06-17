package com.college.student.services.springdatajpa;

import com.college.student.model.Teacher;
import com.college.student.repositories.StreamRepository;
import com.college.student.repositories.SubjectRepository;
import com.college.student.repositories.TeacherRepository;
import com.college.student.services.TeacherService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class TeacherJpaService implements TeacherService {
    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;
    private final StreamRepository streamRepository;

    public TeacherJpaService(TeacherRepository teacherRepository, SubjectRepository subjectRepository, StreamRepository streamRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
        this.streamRepository = streamRepository;
    }

    @Override
    public Teacher findByLastName(String lastName) {
        return teacherRepository.findByLastName(lastName);
    }

    @Override
    public Set<Teacher> findAll() {
        Set<Teacher> teachers = new HashSet<>();
        teacherRepository.findAll().forEach(teachers::add);

        return teachers;
    }

    @Override
    public Teacher findById(Long aLong) {
        return teacherRepository.findById(aLong).orElse(null);
    }

    @Override
    public Teacher save(Teacher object) {
        return teacherRepository.save(object);
    }

    @Override
    public void delete(Teacher object) {
        teacherRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        teacherRepository.deleteById(aLong);
    }
}

