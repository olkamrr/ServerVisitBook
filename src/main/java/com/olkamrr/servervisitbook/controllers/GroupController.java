package com.olkamrr.servervisitbook.controllers;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    @GetMapping("/all")
    public List<Group> getAll(){
        return groupService.getAll();
    }

    @PostMapping("/save")
    public Group save(@RequestBody Group group){
        return groupService.save(group);
    }

    @PostMapping("/update/{id}")
    public Group update(@PathVariable(value = "id") int id, @RequestBody Group group){
        return groupService.update(id, group);
    }

    @GetMapping("/delete/{id}")
    public Group delete(@PathVariable(value = "id") int id){
        return groupService.delete(id);
    }
}
