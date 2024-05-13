package com.myapp.myapp.contacts;

import com.myapp.myapp.user.User;
import com.myapp.myapp.user.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Service
public class ContactsService {
    @Autowired private ContactRepository repo;

    public List<Contacts> listAll() {
        return (List<Contacts>) repo.findAll();
    }

    public void save(Contacts contacts) {
        repo.save(contacts);
    }
    public Contacts get (Integer contact_id) throws ContactNotFoundException {
        Optional<Contacts> result = repo.findById(contact_id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ContactNotFoundException("Could not find any contacts with the ID" + contact_id);
    }
}
