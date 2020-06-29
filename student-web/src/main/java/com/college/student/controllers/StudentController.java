package com.college.student.controllers;

import com.college.student.model.Stream;
import com.college.student.model.Student;
import com.college.student.services.StreamService;
import com.college.student.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RequestMapping("/students")
@Controller
public class StudentController
{
    private static final String VIEWS_STUDENT_CREATE_OR_UPDATE_FORM = "students/createOrUpdateStudentForm";

    private final StudentService studentService;
    private final StreamService streamService;

    public StudentController(StudentService studentService, StreamService streamService)
    {
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

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        Student student = Student.builder().build();
        model.addAttribute("student", student);
        return VIEWS_STUDENT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_STUDENT_CREATE_OR_UPDATE_FORM;
        }
        else {
            Student savedStudent = studentService.save(student);
            return "redirect:/students/" + savedStudent.getId();
        }
    }

    @GetMapping("/{studentId}/edit")
    public String initUpdateStudentForm(@PathVariable("studentId") Long studentId, Model model) {
        Student student = studentService.findById(studentId);
        model.addAttribute(student);
        return VIEWS_STUDENT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{studentId}/edit")
    public String processUpdateStudentForm(@Valid Student student, BindingResult result,
                                         @PathVariable("studentId") Long studentId) {
        if (result.hasErrors()) {
            return VIEWS_STUDENT_CREATE_OR_UPDATE_FORM;
        }
        else {
            Student realStudent = studentService.findById(studentId);
            realStudent.setPhone(student.getPhone());
            realStudent.setCity(student.getCity());
            realStudent.setAddress(student.getAddress());
            realStudent.setFirstName(student.getFirstName());
            realStudent.setLastName(student.getLastName());
            Stream newStream = streamService.save(student.getStream());
            realStudent.setStream(newStream);
            newStream.getStudents().add(realStudent);
            studentService.save(realStudent);
            return "redirect:/students/" + realStudent.getId();
        }
    }

    @RequestMapping("/find")
    public String initFindForm(Model model)
    {
        model.addAttribute("student",Student.builder().build());
        return "students/findStudents";
    }

    @GetMapping({"/",""})
    public String processFindForm(Student student, BindingResult result, Model model)
    {
        // allow parameterless GET request for /students to return all records
        if (student.getLastName() == null) {
            student.setLastName(""); // empty string signifies broadest possible search
        }

        // find students by last name
        List<Student> results = studentService.findAllByLastNameLike("%" + student.getLastName() + "%");

        if (results.isEmpty()) {
            // no students found
            result.rejectValue("lastName", "notFound", "not found");
            return "students/findStudents";
        }
        else if (results.size() == 1) {
            // 1 owner found
            student = results.get(0);
            return "redirect:/students/" + student.getId();
        }
        else {
            // multiple students found
            model.addAttribute("selections", results);
            return "students/studentList";
        }
    }

    @GetMapping("/{studentId}")
    public ModelAndView showStudent(@PathVariable("studentId") Long studentId) {
        ModelAndView mav = new ModelAndView("students/studentDetails");
        mav.addObject(studentService.findById(studentId));
        return mav;
    }
}
