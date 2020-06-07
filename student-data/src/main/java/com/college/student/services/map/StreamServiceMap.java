package com.college.student.services.map;

import com.college.student.model.Stream;
import com.college.student.model.Student;
import com.college.student.services.CrudService;

import java.util.Set;

public class StreamServiceMap extends AbstractMapService<Stream, Long> implements CrudService<Stream, Long>
{
    @Override
    public Set<Stream> findAll() {
        return super.findAll();
    }

    @Override
    public Stream findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Stream save(Stream object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Stream object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
