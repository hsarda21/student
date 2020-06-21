package com.college.student.services.springdatajpa;

import com.college.student.model.Stream;
import com.college.student.model.Student;
import com.college.student.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StudentJpaServiceTest
{
    public static final String LAST_NAME = "Smith";
    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentJpaService studentJpaService;

    Student returnStudent;

    @BeforeEach
    void setUp()
    {
        returnStudent = Student.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName()
    {
        when(studentRepository.findByLastName(any())).thenReturn(returnStudent);

        Student student = studentJpaService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, student.getLastName());

        verify(studentRepository).findByLastName(any());
    }

    @Test
    void findAll()
    {
        Set<Student> returnStudentsSet = new HashSet<>();
        returnStudentsSet.add(Student.builder().id(1L).build());
        returnStudentsSet.add(Student.builder().id(2L).build());

        when(studentRepository.findAll()).thenReturn(returnStudentsSet);

        Set<Student> students = studentJpaService.findAll();

        assertNotNull(students);
        assertEquals(2,students.size());

    }

    @Test
    void findById()
    {
        when(studentRepository.findById(anyLong())).thenReturn(Optional.of(returnStudent));

        Student student =  studentJpaService.findById(1L);

        assertNotNull(student);
    }

    @Test
    void findByIdNotFound()
    {
        when(studentRepository.findById(anyLong())).thenReturn(Optional.empty());

        Student student =  studentJpaService.findById(1L);

        assertNull(student);
    }

    @Test
    void save()
    {
        Student studentToSave = Student.builder().id(1L).subjects(new HashSet<>()).stream(new Stream()).build();

        when(studentRepository.save(any())).thenReturn(returnStudent);

        Student student = studentJpaService.save(studentToSave);

        assertNotNull(student);
    }

    @Test
    void delete()
    {
        studentJpaService.delete(returnStudent);

        verify(studentRepository, times(1)).delete(any());
    }

    @Test
    void deleteById()
    {
        studentJpaService.deleteById(returnStudent.getId());

        verify(studentRepository).deleteById(anyLong());

    }
}