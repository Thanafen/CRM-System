package com.myapp.myapp.contacts;

import javax.persistence.*;

@Entity
@Table (name = "contacts")
public class Contacts {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer contact_id;
    @Column(nullable = false, length = 45)
    private String clientName;
    @Column(nullable = false, length =  70)
    private String description;
    @Column(nullable = false, length =  45)
    private String employee;
    @Column( length = 20)
    private String contactStatus;




    @Override
    public String toString() {
        return "Contacts{" +
                "contact_id=" + getContact_id() +
                ", clientName='" + getClientName() + '\'' +
                ", description='" + getDescription() + '\'' +
                ", employee='" + getEmployee() + '\'' +
                ", contactStatus='" + getContactStatus() + '\'' +
                '}';
    }

    public Integer getContact_id() {
        return contact_id;
    }

    public void setContact_id(Integer contact_id) {
        this.contact_id = contact_id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getContactStatus() {
        return contactStatus;
    }

    public void setContactStatus(String contactStatus) {
        this.contactStatus = contactStatus;
    }
}
