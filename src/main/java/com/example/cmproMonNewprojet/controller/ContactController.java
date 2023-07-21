package com.example.cmproMonNewprojet.controller;

import com.example.cmproMonNewprojet.models.Contact;
import com.example.cmproMonNewprojet.service.ContactService;
import com.example.cmproMonNewprojet.service.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    /*@GetMapping("/contact")
    public String showList(Model model){
        List<Contact> listContacts = contactService.getList();
        model.addAttribute("listContacts", listContacts);
        return "contact";
    }*/
    @GetMapping("/contact")
    public String showList(Model model){
        List<Contact> listContacts = contactService.getList();
        model.addAttribute("listContacts", listContacts);
        return "table-datatable-basic";
    }

   /* @GetMapping("/contact/new")
    public String showFormAdd(Model model){
        model.addAttribute("contact", new Contact());
        model.addAttribute("pageTitle", "Add New Contact");
        return "contact_form";
    }*/

    @GetMapping("/contact/new")
    public String showFormAdd(Model model){
        model.addAttribute("contact", new Contact());
        model.addAttribute("pageTitle", "Add New Contact");
        return "form-validation";
    }

    /*@PostMapping("/contact/save")
    public String saveUser(Contact contact, RedirectAttributes ra){
        contactService.add(contact);
        ra.addFlashAttribute("message", "The contact has been saved successfully");
        return "redirect:/contact";
    }*/

    @PostMapping("/contact/save")
    public String saveUser(Contact contact, Model model, RedirectAttributes ra){
        contactService.add(contact);
        ra.addFlashAttribute("message", "The contact has been saved successfully");
        List<Contact> listContacts = contactService.getList();
        model.addAttribute("listContacts", listContacts);
        return "table-datatable-basic";
    }
    /*@PostMapping("/contact/save")
    public String saveUser(Contact contact, RedirectAttributes ra){
        contactService.add(contact);
        ra.addFlashAttribute("message", "The contact has been saved successfully");
        return "redirect:/table-datatable-basic";
    }*/

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

    @GetMapping("/contact/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Contact contact = contactService.get(id);
            model.addAttribute("contact", contact);
            model.addAttribute("pageTitle", "Edit Contact (ID: " + id + ")");
            return "contact_form";

        } catch (UserPrincipalNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/contact";
        }
    }

    @GetMapping("/contact/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            contactService.delete(id);
            ra.addFlashAttribute("message", "The contact ID " + id + " has been deleted.");
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        } catch (UserPrincipalNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "redirect:/contact";
    }

    }

