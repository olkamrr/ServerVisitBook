package com.olkamrr.servervisitbook.controllers;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.Student;
import com.olkamrr.servervisitbook.services.GroupService;
import com.olkamrr.servervisitbook.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentRestController {
    private StudentService studentService;
    private GroupService groupService;

    @Autowired
    public StudentRestController(StudentService studentService, GroupService groupService){
        this.studentService = studentService;
        this.groupService = groupService;
    }

    @PostMapping("/save/{groupId}")
    public Student save(@RequestBody Student student, @PathVariable("groupId") int groupId){
        return studentService.save(student, groupId);
    }

    @PostMapping("/update/{id}")
    public Student update(@PathVariable(value = "id") int id, @RequestBody Student student){
        Group group = studentService.findGroup(id);
        return studentService.update(id, student, group);
    }

    @GetMapping("/delete/{id}")
    public Student delete(@PathVariable(value = "id") int id){
        return studentService.delete(id);
    }

    /*@GetMapping("/{groupId}")
    public List<Student> studentByGroup(@PathVariable(value = "groupId") int groupId){
        List<Student> students = studentService.studentByGroupOrderByLastNameAsc(groupId);
        return students;
    }*/

    @GetMapping("/transfer/{id}/{groupId}")
    public Student updateGroup(@PathVariable(value = "id") int id, @PathVariable(value = "groupId") int groupId){
        Group group = groupService.findOne(groupId);
        Student student = studentService.findOne(id);
        return studentService.updateGroup(id, student, group);
    }
}
