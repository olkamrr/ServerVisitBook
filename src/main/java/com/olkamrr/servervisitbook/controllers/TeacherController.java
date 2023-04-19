package com.olkamrr.servervisitbook.controllers;

import com.olkamrr.servervisitbook.models.Teacher;
import com.olkamrr.servervisitbook.models.User;
import com.olkamrr.servervisitbook.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("teachers", teacherService.getAll());
        return "teacher/index";
    }

    @GetMapping("/create/{id}")
    public String create(@ModelAttribute("teacher") Teacher teacher, @PathVariable("id") int id, Model model) {
        model.addAttribute("user", id);
        return "teacher/create";
    }

    @PostMapping("/create/{id}")
    public String save(@ModelAttribute("teacher")Teacher teacher, @PathVariable("id") int id) {
        teacherService.save(teacher, id);
        return "redirect:/user/teacher";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("teacher", teacherService.findOne(id));
        return "teacher/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("teacher") Teacher teacher, @PathVariable("id") int id) {
        User user = teacherService.findUser(id);
        teacherService.update(id, teacher, user);
        return "redirect:/teacher/";
    }
}
