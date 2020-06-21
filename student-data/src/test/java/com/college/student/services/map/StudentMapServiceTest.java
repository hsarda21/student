package com.college.student.services.map;

import com.college.student.model.Stream;
import com.college.student.model.Student;
import com.college.student.services.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapServiceTest {

    StudentMapService studentMapService;

    final Long studentId = 1L;
    final String lastName = "Smith";

    @BeforeEach
    void setUp() {
        studentMapService = new StudentMapService(new SubjectMapService());

        studentMapService.save(Student.builder().id(studentId).subjects(new HashSet<>()).stream(new Stream()).
                lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Student> studentSet = studentMapService.findAll();

        assertEquals(1,studentSet.size());
    }

    @Test
    void findById()
    {
        Student student = studentMapService.findById(studentId);

        assertEquals(studentId,student.getId());
    }

    @Test
    void saveExistingId()
    {
        Long id = 2L;
        Student student2 = Student.builder().id(2L).subjects(new HashSet<>()).stream(new Stream()).build();
        Student savedStudent = studentMapService.save(student2);

        assertEquals(id, savedStudent.getId());
    }

    @Test
    void saveNoId()
    {
        Student savedStudent = studentMapService.save(Student.builder().subjects(new HashSet<>()).stream(new Stream()).build());

        assertNotNull(savedStudent);
        assertNotNull(savedStudent.getId());
    }

    @Test
    void delete()
    {
        studentMapService.delete(studentMapService.findById(studentId));

        assertEquals(0,studentMapService.findAll().size());
    }

    @Test
    void deleteById()
    {
        studentMapService.deleteById(studentId);

        assertEquals(0,studentMapService.findAll().size());
    }

    @Test
    void findByLastName()
    {
       Student student2 = studentMapService.findByLastName(lastName);

        assertNotNull(student2);
        assertEquals(studentId, student2.getId());
    }
}