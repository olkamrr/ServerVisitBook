package com.olkamrr.servervisitbook.controllers;

import com.olkamrr.servervisitbook.models.Teacher;
import com.olkamrr.servervisitbook.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping("/all")
    public List<Teacher> getAll(){
        return teacherService.getAll();
    }

    @PostMapping("/save")
    public Teacher save(@RequestBody Teacher teacher){
        return teacherService.save(teacher);
    }

    @PostMapping("/update/{id}")
    public Teacher update(@PathVariable(value = "id") int id, @RequestBody Teacher teacher){
        return teacherService.update(id, teacher);
    }
}
