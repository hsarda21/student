package com.college.student.services.map;

import com.college.student.model.Student;
import com.college.student.model.Subject;
import com.college.student.services.StudentService;
import com.college.student.services.SubjectService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class StudentServiceMap extends AbstractMapService<Student, Long> implements StudentService
{
    private final SubjectService subjectService;

    public StudentServiceMap(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

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

        if(object != null)
        {
            if(object.getSubjects().size() > 0)
            {
                object.getSubjects().forEach(subject -> {
                    Subject savedSubject = subjectService.save(subject);
                    subject.setId(savedSubject.getId());
                });
            }
            return super.save(object);
        }
        else
        {
            return null;
        }
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
