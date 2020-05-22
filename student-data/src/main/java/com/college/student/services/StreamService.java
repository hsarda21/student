package com.college.student.services;

import com.college.student.model.Stream;

import java.util.Set;

public interface StreamService
{
    Stream findById(Long id);

    Stream save(Stream stream);

    Set<Stream> findAll();
}
