package com.xiangyong.entity;

import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yuxiangyong on 2017/5/6.
 */
@Entity
@Table(name = "contacts")
public class ContactInfo implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;

    @Id
    @GeneratedValue
    //@Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        if(id<=0) {
            return String.format("firstName:%s,lastName:%s,emailAddress:%s,phoneNumber:%s", firstName, lastName, emailAddress, phoneNumber);
        }else {
            return String.format("id:%d, firstName:%s,lastName:%s,emailAddress:%s,phoneNumber:%s", id, firstName, lastName, emailAddress, phoneNumber);
        }
    }
}
