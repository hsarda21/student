package com.college.student.services.springdatajpa;

import com.college.student.model.Student;
import com.college.student.repositories.StreamRepository;
import com.college.student.repositories.StudentRepository;
import com.college.student.repositories.SubjectRepository;
import com.college.student.services.StudentService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class StudentJpaService implements StudentService
{
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final StreamRepository streamRepository;

    public StudentJpaService(StudentRepository studentRepository, SubjectRepository subjectRepository, StreamRepository streamRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.streamRepository = streamRepository;
    }

    @Override
    public Student findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    @Override
    public Set<Student> findAll() {
        Set<Student> students = new HashSet<>();
        studentRepository.findAll().forEach(students::add);

        return students;
    }

    @Override
    public Student findById(Long aLong) {
        return studentRepository.findById(aLong).orElse(null);
    }

    @Override
    public Student save(Student object) {
        return studentRepository.save(object);
    }

    @Override
    public void delete(Student object) {
        studentRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        studentRepository.deleteById(aLong);
    }
}
