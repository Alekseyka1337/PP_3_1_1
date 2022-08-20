package com.ratnikov.pp_3_1_1.controller;

import com.ratnikov.pp_3_1_1.entity.User;
import com.ratnikov.pp_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String getAllUsers (Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "getAllUsers.html";
    }

    @GetMapping(value = "/new")
    public String createUserForm (Model model) {
        model.addAttribute("user", new User());
        return "/createUser.html";
    }

    @GetMapping(value = "/{id}/update")
    public String updateUserByIdForm (@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "updateUser.html";
    }

    @DeleteMapping(value = "/{id}/delete")
    public String deleteUserById (@PathVariable("id") int id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
    @PostMapping
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/createUser.html";
        }
        userService.createUser(user);
        return "redirect:/";
    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/updateUser.html";
        }
        userService.updateUser(user);
        return "redirect:/";
    }
}
