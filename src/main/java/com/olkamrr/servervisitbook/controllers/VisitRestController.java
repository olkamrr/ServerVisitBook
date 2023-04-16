package com.olkamrr.servervisitbook.controllers;

import com.olkamrr.servervisitbook.models.Schedule;
import com.olkamrr.servervisitbook.models.Student;
import com.olkamrr.servervisitbook.models.Visit;
import com.olkamrr.servervisitbook.services.ScheduleService;
import com.olkamrr.servervisitbook.services.StudentService;
import com.olkamrr.servervisitbook.services.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/visit")
public class VisitRestController {
    private VisitService visitService;
    private StudentService studentService;
    private ScheduleService scheduleService;

    @Autowired
    public VisitRestController(VisitService visitService, StudentService studentService, ScheduleService scheduleService){
        this.visitService = visitService;
        this.studentService = studentService;
        this.scheduleService = scheduleService;
    }

    @PostMapping("/save/{lessonId}/{studentId}")
    public Visit save(@RequestBody Visit visit, @PathVariable("lessonId") int lessonId, @PathVariable("studentId") int studentId){
        return visitService.save(visit, lessonId, studentId);
    }

    @PostMapping("/update/{id}")
    public Visit update(@PathVariable(value = "id") int id, @RequestBody Visit visit){
        Student student = visitService.findStudent(id);
        Schedule lesson = visitService.findSchedule(id);
        return visitService.update(id, visit, lesson, student);
    }
}
