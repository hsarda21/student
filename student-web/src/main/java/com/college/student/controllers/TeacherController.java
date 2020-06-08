package com.college.student.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/teachers")
@Controller
public class TeacherController
{
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listTeachers()
    {
        return "teachers/index";
    }
}
