package com.college.student.bootstrap;

import com.college.student.model.Student;
import com.college.student.model.Teacher;
import com.college.student.services.StudentService;
import com.college.student.services.TeacherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
    private final StudentService studentService;
    private final TeacherService teacherService;

    public DataLoader(StudentService studentService, TeacherService teacherService)
    {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        Student student1 = new Student();
        student1.setId(1L);
        student1.setFirstName("Harshit");
        student1.setLastName("Sarda");

        studentService.save(student1);

        Student student2 = new Student();
        student2.setId(2L);
        student2.setFirstName("Aryaman");
        student2.setLastName("Chaudhary");

        studentService.save(student2);

        System.out.println("Loaded Students...");

        Teacher teacher1 = new Teacher();
        teacher1.setId(1L);
        teacher1.setFirstName("Sanjay");
        teacher1.setLastName("Jain");

        teacherService.save(teacher1);

        Teacher teacher2 = new Teacher();
        teacher2.setId(2L);
        teacher2.setFirstName("Pooja");
        teacher2.setLastName("Parnami");

        teacherService.save(teacher2);

        System.out.println("Loaded Teachers...");
    }
}
