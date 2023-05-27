package com.olkamrr.servervisitbook.controllers;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.services.GroupService;
import com.olkamrr.servervisitbook.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    private ScheduleService scheduleService;
    private GroupService groupService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService, GroupService groupService){
        this.scheduleService = scheduleService;
        this.groupService = groupService;
    }

    @GetMapping("/{groupId}")
    public String lessons(Model model, @PathVariable(value = "groupId") int groupId){
        Group group = groupService.findOne(groupId);
        model.addAttribute("lessons", scheduleService.findLessons(group));
        return "visit/lessons";
    }
}
