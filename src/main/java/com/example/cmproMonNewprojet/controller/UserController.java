package com.example.cmproMonNewprojet.controller;

import com.example.cmproMonNewprojet.models.User;
import com.example.cmproMonNewprojet.service.UserNotFoundException;
import com.example.cmproMonNewprojet.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/cover")
    public String showCover(Model model){
        // model.addAttribute("nom", "Judith");
        return ("cover");
    }

    @GetMapping ("/user")
    public String showList(Model model){
        List<User> listUsers = userService.getList();
        model.addAttribute("listUsers", listUsers);
        return "user";
    }
    @GetMapping("/users/new")
    public String showFormAdd(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add New User");
        return "user_form";
    }

    @PostMapping("/user/save")
    public String saveUser(User user, RedirectAttributes ra){
        userService.add(user);
        ra.addFlashAttribute("message", "The user has been saved successfully");
        return "redirect:/user";
    }

  /* @GetMapping("/user/edit/{id}")
        public String showFormEdit(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try{
           User user =  userService.get(id);
           model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User(ID: "+ id +" )");
            return "user_form";
        } catch (UserPrincipalNotFoundException e) {
            ra.addFlashAttribute("message", "The user has been saved successfully.");
            return "redirect:/user";
        }
   }*/

    @GetMapping("/user/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            User user = userService.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User (ID: " + id + ")");
            return "user_form";

        } catch (UserPrincipalNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/user";
        }
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            userService.delete(id);
            ra.addFlashAttribute("message", "The user ID " + id + " has been deleted.");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        } catch (UserPrincipalNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/user";
    }


}
