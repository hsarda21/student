package com.college.student.controllers;

import com.college.student.model.Student;
import com.college.student.services.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest
{
    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    Set<Student> students;

    MockMvc mockMvc;

    @BeforeEach
    void setUp()
    {
        students = new HashSet<>();
        students.add(Student.builder().id(1L).build());
        students.add(Student.builder().id(2L).build());

        mockMvc = MockMvcBuilders.standaloneSetup(studentController).build();
    }

    @Test
    void listStudents() throws Exception
    {
        when(studentService.findAll()).thenReturn(students);

        mockMvc.perform(get("/students")).andExpect(status().isOk()).
                andExpect(view().name("students/index")).andExpect(model().attribute("owners",hasSize(2)));
    }
}