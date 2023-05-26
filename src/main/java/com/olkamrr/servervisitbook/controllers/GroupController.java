package com.olkamrr.servervisitbook.controllers;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.User;
import com.olkamrr.servervisitbook.services.GroupService;
import com.olkamrr.servervisitbook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class GroupController {
    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService){
        this.groupService = groupService;
    }

    @GetMapping("/groups")
    public String index(Model model) {
        model.addAttribute("groups", groupService.getAll());
        return "group/index";
    }

    @GetMapping("/visits/groups")
    public String indexVisit(Model model) {
        model.addAttribute("groups", groupService.getAll());
        return "visit/index";
    }

    @GetMapping("/group/create/{id}")
    public String create(@ModelAttribute("group") Group group, @PathVariable("id") int id, Model model) {
        model.addAttribute("user", id);
        return "group/create";
    }

    @PostMapping("/group/create/{id}")
    public String save(@ModelAttribute("group") Group group, @PathVariable("id") int id) {
        groupService.save(group, id);
        return "redirect:/user/student";
    }

    @GetMapping("/group/edit/{id}")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("group", groupService.findOne(id));
        return "group/edit";
    }

    @PostMapping("/group/edit/{id}")
    public String update(@ModelAttribute("group") Group group, @PathVariable("id") int id) {
        User user = groupService.findUser(id);
        groupService.update(id, group, user);
        return "redirect:/groups";
    }

    @PostMapping("/group/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        groupService.delete(id);
        return "redirect:/groups";
    }
}
