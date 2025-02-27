package com.college.student.bootstrap;

import com.college.student.model.Stream;
import com.college.student.model.Student;
import com.college.student.model.Subject;
import com.college.student.model.Teacher;
import com.college.student.services.StreamService;
import com.college.student.services.StudentService;
import com.college.student.services.SubjectService;
import com.college.student.services.TeacherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner
{
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final StreamService streamService;
    private final SubjectService subjectService;

    public DataLoader(StudentService studentService, TeacherService teacherService, StreamService streamService, SubjectService subjectService)
    {
        this.studentService = studentService;
        this.teacherService = teacherService;
        this.streamService = streamService;
        this.subjectService = subjectService;
    }

    @Override
    public void run(String... args) throws Exception
    {
        int count = subjectService.findAll().size();

        if(count == 0)
        {
            loadData();
        }
    }

    private void loadData() {
        Stream btech = new Stream();
        btech.setStreamName("Bachelors of Technology");

        Stream savedbtech = streamService.save(btech);

        Stream bca = new Stream();
        bca.setStreamName("Bachelors of Computer Administration");

        Stream savedbca = streamService.save(bca);

        Subject java = new Subject();
        java.setSubjectName("Java");
        java.setStream(savedbtech);

        Subject savedJava = subjectService.save(java);

        Subject os = new Subject();
        os.setSubjectName("Operating System");
        os.setStream(savedbca);

        Subject savedOs = subjectService.save(os);

        Student student1 = new Student();
        student1.setFirstName("Harshit");
        student1.setLastName("Sarda");
        student1.setAddress("Jhotwara");
        student1.setCity("Jaipur");
        student1.setPhone("8959851423");
        student1.setStream(btech);
        savedJava.getStudents().add(student1);
        student1.getSubjects().add(savedJava);

        studentService.save(student1);
        subjectService.save(savedJava);

        Student student2 = new Student();
        student2.setFirstName("Aryaman");
        student2.setLastName("Chaudhary");
        student2.setAddress("Jawahar Nagar");
        student2.setCity("Jaipur");
        student2.setPhone("6350486269");
        student2.setStream(bca);
        savedOs.getStudents().add(student2);
        student2.getSubjects().add(savedOs);

        studentService.save(student2);
        subjectService.save(savedOs);

        System.out.println("Loaded Students...");

        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Sanjay");
        teacher1.setLastName("Jain");
        teacher1.setStream(savedbtech);
        teacher1.getSpecialities().add(savedJava);

        teacherService.save(teacher1);

        Teacher teacher2 = new Teacher();
        teacher2.setFirstName("Pooja");
        teacher2.setLastName("Parnami");
        teacher2.setStream(savedbca);
        teacher2.getSpecialities().add(savedOs);

        teacherService.save(teacher2);

        System.out.println("Loaded Teachers...");
    }
}
