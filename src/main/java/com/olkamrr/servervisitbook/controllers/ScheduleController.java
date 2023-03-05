package com.olkamrr.servervisitbook.controllers;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.Schedule;
import com.olkamrr.servervisitbook.models.Student;
import com.olkamrr.servervisitbook.services.GroupService;
import com.olkamrr.servervisitbook.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    private ScheduleService scheduleService;
    private GroupService groupService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService, GroupService groupService){
        this.scheduleService = scheduleService;
        this.groupService = groupService;
    }

    @PostMapping("/save/{groupId}")
    public Schedule save(@RequestBody Schedule lesson, @PathVariable("groupId") int groupId){
        return scheduleService.save(lesson, groupId);
    }

    @PostMapping("/update/{id}")
    public Schedule update(@PathVariable(value = "id") int id, @RequestBody Schedule lesson){
        Group group = scheduleService.findGroup(id);
        return scheduleService.update(id, lesson, group);
    }

    @GetMapping("/delete/{id}")
    public Schedule delete(@PathVariable(value = "id") int id){
        return scheduleService.delete(id);
    }

    @GetMapping("/{groupId}")
    public List<Schedule> schedulesByGroup(@PathVariable(value = "groupId") int groupId){
        List<Schedule> lessons = scheduleService.schedulesByGroup(groupId);
        return lessons;
    }

    @GetMapping("/{groupId}/{semester}")
    public List<Schedule> schedulesByGroupAndSemester(@PathVariable(value = "groupId") int groupId, @PathVariable(value = "semester") int semester){
        List<Schedule> lessons = scheduleService.schedulesByGroupAndSemester(groupId, semester);
        return lessons;
    }
}
