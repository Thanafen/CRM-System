package com.myapp.myapp.contacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ContactsController {
    @Autowired private ContactsService service; // Corrected annotation

    @GetMapping("/contacts")
    public String showContactsList(Model model) {
        List<Contacts> contacts = service.listAll();
        model.addAttribute("listContacts", contacts);
        return "contacts";
    }
    @GetMapping("/contacts/new")
    public String showNewForm(Model model) {
        model.addAttribute("contact", new Contacts());
        model.addAttribute("pageTitle", "Add new contact");
        return "contacts_form";
    }
    @PostMapping("/contacts/save")
    public String saveContact(Contacts contacts) {
        service.save(contacts);
        return "redirect:/contacts";
    }
    @GetMapping("/contacts/edit/{contact_id}")
    public String showEditForm(@PathVariable("contact_id") Integer contact_id, Model model) {
        try {
            Contacts contacts = service.get(contact_id);
            model.addAttribute("contact", contacts); // Changed from "contacts" to "contact"
            model.addAttribute("pageTitle", "Edit contact (ID: " + contact_id + ")");
            return "contacts_form";
        } catch (ContactNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

