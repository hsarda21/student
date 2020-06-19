package com.college.student.services.map;

import com.college.student.model.Subject;
import com.college.student.services.SubjectService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class SubjectMapService extends AbstractMapService<Subject, Long> implements SubjectService
{
    @Override
    public Set<Subject> findAll() {
        return super.findAll();
    }

    @Override
    public Subject findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Subject save(Subject object) {
        object.getStream().getSubjects().add(object);
        return super.save(object);
    }

    @Override
    public void delete(Subject object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
