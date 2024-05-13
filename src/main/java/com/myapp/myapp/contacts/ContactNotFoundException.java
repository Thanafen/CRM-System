package com.myapp.myapp.contacts;

public class ContactNotFoundException extends Throwable {
    public ContactNotFoundException(String message) {
        super(message);
    }
}
