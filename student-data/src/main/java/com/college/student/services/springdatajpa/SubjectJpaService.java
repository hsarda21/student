package com.college.student.services.springdatajpa;

import com.college.student.model.Stream;
import com.college.student.model.Student;
import com.college.student.model.Subject;
import com.college.student.repositories.StreamRepository;
import com.college.student.repositories.SubjectRepository;
import com.college.student.services.SubjectService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SubjectJpaService implements SubjectService
{
    private final SubjectRepository subjectRepository;
    private final StreamRepository streamRepository;

    public SubjectJpaService(SubjectRepository subjectRepository, StreamRepository streamRepository) {
        this.subjectRepository = subjectRepository;
        this.streamRepository = streamRepository;
    }

    @Override
    public Set<Subject> findAll() {
        Set<Subject> subjects = new HashSet<>();
        subjectRepository.findAll().forEach(subjects::add);

        return subjects;
    }

    @Override
    public Subject findById(Long aLong) {
        return subjectRepository.findById(aLong).orElse(null);
    }

    @Override
    public Subject save(Subject object) {
        object.getStream().getSubjects().add(object);

        if(object.getStudents()!=null)
        {
            object.getStudents().forEach(student -> student.getSubjects().add(object));
        }
        return subjectRepository.save(object);
    }

    @Override
    public void delete(Subject object) {
        subjectRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        subjectRepository.deleteById(aLong);
    }
}
