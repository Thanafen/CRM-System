package com.myapp.myapp;

import com.myapp.myapp.contacts.ContactRepository;
import com.myapp.myapp.contacts.Contacts;
import com.myapp.myapp.user.User;
import com.myapp.myapp.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class ContactRepositoryTests {

    @Autowired
    private ContactRepository repo;

    @Test
    public void testAddNew() {
        Contacts contacts = new Contacts(); // Declaration of User entity here
        contacts.setClientName("Johnathan");
        contacts.setDescription("New Phone");
        contacts.setEmployee("James");


        Contacts savedContacts = repo.save(contacts);

        Assertions.assertThat(savedContacts).isNotNull();

    }

}
