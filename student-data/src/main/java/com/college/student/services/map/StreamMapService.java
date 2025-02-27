package com.college.student.services.map;

import com.college.student.model.Stream;
import com.college.student.services.StreamService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class StreamMapService extends AbstractMapService<Stream, Long> implements StreamService
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
        return super.save(object);
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
