package com.college.student.services.springdatajpa;

import com.college.student.model.Stream;
import com.college.student.model.Student;
import com.college.student.repositories.StreamRepository;
import com.college.student.services.StreamService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@Profile("springdatajpa")
public class StreamJpaService implements StreamService
{
    private final StreamRepository streamRepository;

    public StreamJpaService(StreamRepository streamRepository) {
        this.streamRepository = streamRepository;
    }

    @Override
    public Set<Stream> findAll() {
        Set<Stream> streams = new HashSet<>();
        streamRepository.findAll().forEach(streams::add);

        return streams;
    }

    @Override
    public Stream findById(Long aLong) {
        return streamRepository.findById(aLong).orElse(null);
    }

    @Override
    public Stream save(Stream object) {
        return streamRepository.save(object);
    }

    @Override
    public void delete(Stream object) {
        streamRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        streamRepository.deleteById(aLong);
    }
}
