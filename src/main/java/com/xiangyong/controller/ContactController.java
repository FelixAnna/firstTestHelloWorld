package com.xiangyong.controller;

import com.xiangyong.entity.ContactInfo;
import com.xiangyong.exception.DataNotFoundException;
import com.xiangyong.exception.Error;
import com.xiangyong.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yuxiangyong on 2017/5/6.
 */
@RestController
@RequestMapping("/contact/")
public class ContactController {
    private ContactRepository repository;

    @Autowired
    ContactController(ContactRepository repo){
        this.repository = repo;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ContactInfo findContactById(@PathVariable(name = "id")Long id) {
        ContactInfo contact= repository.findById(id);
        if(contact == null) {
            throw new DataNotFoundException(id);
        }
        return contact;
    }
    @RequestMapping(value = {"/count","/total"},method = RequestMethod.GET)
    public Long contactsCount() {
        Long totalCount = repository.count();
        if(totalCount == null || totalCount<= 0) {
            throw new DataNotFoundException(-1);
        }
        return totalCount;
    }
    @RequestMapping(value = {"/all","/list","/"},method = RequestMethod.GET)
    public Page<ContactInfo> contacts(@RequestParam(value = "skip", defaultValue = "0")int skip
                                        ,@RequestParam(value = "take", defaultValue = "20")int take) {
        Pageable pageable = new PageRequest(skip, take);

        Page<ContactInfo> contacts= repository.findAll(pageable);
        if(contacts == null || !contacts.hasContent()) {
            throw new DataNotFoundException(-1);
        }
        return contacts;
    }

    @RequestMapping(value = "/",method = RequestMethod.POST,consumes = "application/json")
    public ContactInfo addContact(@RequestBody  ContactInfo contactInfo) {
        ContactInfo newContact= repository.save(contactInfo);
        /*for(int i=0;i<1000;i++){
            ContactInfo newContactInfo =new ContactInfo();
            newContactInfo.setFirstName(contactInfo.getFirstName());
            newContactInfo.setLastName(contactInfo.getLastName());
            newContactInfo.setEmailAddress(contactInfo.getEmailAddress());
            newContactInfo.setPhoneNumber(contactInfo.getPhoneNumber());
            repository.save(newContactInfo);
        }*/
        if(newContact == null) {
            throw new RuntimeException(String.format("failed to save contact:%s", contactInfo.toString()));
        }
        return newContact;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delContactById(@PathVariable(name = "id")Long id) {
        repository.delete(id);
        return String.format("Contact with id:%d have been removed", id);
    }

    @RequestMapping(value = "/all",method = RequestMethod.DELETE)
    public String delContactById() {
        repository.deleteAll();
        return String.format("Contact purged.");
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT,consumes = "application/json")
    public ContactInfo updateContact(@PathVariable(name = "id")Long id,
                                     @RequestBody  ContactInfo contactInfo){
        if(contactInfo.getId() == null || contactInfo.getId()<= 0) {
            contactInfo.setId(id);
        }
        ContactInfo newContact= repository.saveAndFlush(contactInfo);
        if(newContact == null) {
            throw new RuntimeException(String.format("failed to save contact:%s", contactInfo.toString()));
        }
        return newContact;
    }
}
