package com.olkamrr.servervisitbook.controllers;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.Student;
import com.olkamrr.servervisitbook.services.GroupService;
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
    private GroupService groupService;

    @Autowired
    public StudentController(StudentService studentService, GroupService groupService) {
        this.studentService = studentService;
        this.groupService = groupService;
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

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("student", studentService.findOne(id));
        return "student/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("student") Student student, @PathVariable("id") int id) {
        Group group = studentService.findGroup(id);
        studentService.update(id, student, group);
        return "redirect:/student/" + group.getId();
    }

    @GetMapping("/transfer/{id}")
    public String transfer(Model model, @PathVariable("id") int id) {
        model.addAttribute("student", studentService.findOne(id));
        model.addAttribute("groups", groupService.getAll());
        return "student/transfer";
    }

    @PostMapping("/transfer/{id}")
    public String transfers(@ModelAttribute("student") Student student, @PathVariable("id") int id) {
        studentService.updateGroup(id, student.getGroupId());
        Group group = studentService.findGroup(id);
        return "redirect:/student/" + group.getId();
    }
}
