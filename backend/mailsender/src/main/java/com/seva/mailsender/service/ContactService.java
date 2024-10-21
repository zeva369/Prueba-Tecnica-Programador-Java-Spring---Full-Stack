package com.seva.mailsender.service;

import java.util.List;

import com.seva.mailsender.exception.DuplicatedElementException;
import com.seva.mailsender.exception.ElementNotFoundException;
import com.seva.mailsender.model.Contact;

public interface ContactService extends EntityService<Contact, String >{
   public Contact create(Contact contactIn) throws DuplicatedElementException;
   public List<Contact> findByNameContaining(String namePattern);
   public void deleteById(String id) throws ElementNotFoundException;
}
