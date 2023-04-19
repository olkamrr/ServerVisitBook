package com.olkamrr.servervisitbook.controllers;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.Student;
import com.olkamrr.servervisitbook.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{groupId}")
    public String index(Model model, @PathVariable("groupId") int groupId) {
        List<Student> students = studentService.studentByGroupOrderByLastNameAsc(groupId);
        model.addAttribute("students", students);
        return "student/index";
    }

    @GetMapping("/create/{groupId}")
    public String create(@ModelAttribute("student") Student student, @PathVariable("groupId") int groupId, Model model) {
        model.addAttribute("group", groupId);
        return "student/create";
    }

    @PostMapping("/create/{groupId}")
    public String save(@ModelAttribute("student") Student student, @PathVariable("groupId") int groupId) {
        studentService.save(student, groupId);
        return "redirect:/student/{groupId}";
    }
}
