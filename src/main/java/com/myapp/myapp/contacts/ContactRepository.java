package com.myapp.myapp.contacts;

import com.myapp.myapp.user.User;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contacts, Integer> {
}
