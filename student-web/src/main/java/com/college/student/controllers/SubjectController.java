package com.college.student.controllers;

import com.college.student.model.Stream;
import com.college.student.model.Student;
import com.college.student.model.Subject;
import com.college.student.services.StreamService;
import com.college.student.services.StudentService;
import com.college.student.services.SubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
public class SubjectController
{
    private static final String VIEWS_SUBJECT_CREATE_OR_UPDATE_FORM = "subjects/createOrUpdateSubjectForm";

    private final SubjectService subjectService;
    private final StudentService studentService;
    private final StreamService streamService;


    public SubjectController(SubjectService subjectService, StudentService studentService, StreamService streamService) {
        this.subjectService = subjectService;
        this.studentService = studentService;
        this.streamService = streamService;
    }

    @InitBinder
    public void setDisallowedFields(WebDataBinder dataBinder)
    {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("streams")
    public Collection<Stream> populateStreams() {
        return streamService.findAll();
    }

    @ModelAttribute("student")
    public Student loadStudentWithSubject(@PathVariable("studentId") Long studentId, Model model) {
        Student student = studentService.findById(studentId);
        model.addAttribute("student", student);
        Subject subject = new Subject();
        student.getSubjects().add(subject);
        return student;
    }

    @GetMapping("/students/{studentId}/subjects/new")
    public String initCreationForm(Model model, @PathVariable Long studentId) {
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        Student student = studentService.findById(studentId);
        model.addAttribute("student",student);
        return VIEWS_SUBJECT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/students/{studentId}/subjects/new")
    public String processCreationForm(@Valid Subject subject, BindingResult result, @PathVariable Long studentId)
    {
        if (result.hasErrors()) {
            return VIEWS_SUBJECT_CREATE_OR_UPDATE_FORM;
        }
        else
        {
            Subject newSubject = new Subject();
            newSubject.setSubjectName(subject.getSubjectName());
            Stream savedStream = streamService.save(subject.getStream());
            newSubject.setStream(savedStream);
            savedStream.getSubjects().add(newSubject);
            Student student = studentService.findById(studentId);
            student.getSubjects().add(newSubject);
            Student savedStudent = studentService.save(student);
            subjectService.save(newSubject);
            return "redirect:/students/" + savedStudent.getId();
        }
    }
}
