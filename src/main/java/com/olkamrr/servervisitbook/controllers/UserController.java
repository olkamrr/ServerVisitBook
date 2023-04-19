package com.olkamrr.servervisitbook.controllers;

import com.olkamrr.servervisitbook.models.Group;
import com.olkamrr.servervisitbook.models.User;
import com.olkamrr.servervisitbook.models.enums.Role;
import com.olkamrr.servervisitbook.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Map;

@Controller
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Пользователь " + user.getLogin() + " уже существует");
            return "/registration";
        }
        userService.createUser(user);
        return "redirect:/user/index";
    }

    @GetMapping("user/index")
    public String index(Model model) {
        model.addAttribute("users", userService.getAll());
        return "user/index";
    }

    @GetMapping("user/admin")
    public String admin(Model model) {
        model.addAttribute("users", userService.getRole(Role.ROLE_ADMIN));
        return "user/admin";
    }

    @GetMapping("user/student")
    public String student(Model model) {
        model.addAttribute("users", userService.getRole(Role.ROLE_STUDENT));
        return "user/student";
    }

    @GetMapping("user/teacher")
    public String teacher(Model model) {
        model.addAttribute("users", userService.getRole(Role.ROLE_TEACHER));
        return "user/teacher";
    }

    @GetMapping("/user/edit/{id}")
    public String edit (@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.findOne(id));
        model.addAttribute("roles", Role.values());
        return "user/edit";
    }

    @PostMapping("/user/edit/{id}")
    public String update(@RequestParam("userId") User user, @RequestParam Map<String, String> form) {
        userService.changeUserRoles(user, form);
        return "redirect:/user/index";
    }

    @PostMapping("user/disable/{id}")
    public String disable(@PathVariable("id") int id) {
        userService.disable(id);
        return "redirect:/user/index";
    }
}
