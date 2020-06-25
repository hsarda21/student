package com.college.student.controllers;

import com.college.student.model.Student;
import com.college.student.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/students")
@Controller
public class StudentController
{
    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @InitBinder
    public void setDisallowedFields(WebDataBinder dataBinder)
    {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findStudents(Model model)
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
        List<Student> results = studentService.findAllByLastNameLike(student.getLastName());

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
    public ModelAndView showOwner(@PathVariable("studentId") Long studentId) {
        ModelAndView mav = new ModelAndView("students/studentDetails");
        mav.addObject(studentService.findById(studentId));
        return mav;
    }
}
