package com.olkamrr.servervisitbook.controllers;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/group")
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("groups", groupService.getAll());
        return "group/index";
    }

    @GetMapping("/create")
    public String createGroup(@ModelAttribute("group") Group group) {
        return "group/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("group") Group group) {
        groupService.save(group);
        return "redirect:/group/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("group", groupService.findOne(id));
        return "group/edit";
    }

    @PostMapping("/edit/{id}")
    public String update(@ModelAttribute("group") Group group, @PathVariable("id") int id) {
        groupService.update(id, group);
        return "redirect:/group/index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        groupService.delete(id);
        return "redirect:/group/index";
    }
}
