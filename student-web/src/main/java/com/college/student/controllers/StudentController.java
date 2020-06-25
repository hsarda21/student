package com.college.student.controllers;

import com.college.student.model.Student;
import com.college.student.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/students")
@Controller
public class StudentController
{
    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listStudents(Model model)
    {
        model.addAttribute("students",studentService.findAll());

        return "students/index";
    }

    @GetMapping("/{studentId}")
    public ModelAndView showOwner(@PathVariable("studentId") Long studentId) {
        ModelAndView mav = new ModelAndView("students/studentDetails");
        mav.addObject(studentService.findById(studentId));
        return mav;
    }
}
