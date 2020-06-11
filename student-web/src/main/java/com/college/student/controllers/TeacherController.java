package com.college.student.controllers;

import com.college.student.services.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/teachers")
@Controller
public class TeacherController
{
    TeacherService teacherService;

    public TeacherController(TeacherService teacherService)
    {
        this.teacherService = teacherService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listTeachers(Model model)
    {
        model.addAttribute("teachers",teacherService.findAll());
        return "teachers/index";
    }
}
