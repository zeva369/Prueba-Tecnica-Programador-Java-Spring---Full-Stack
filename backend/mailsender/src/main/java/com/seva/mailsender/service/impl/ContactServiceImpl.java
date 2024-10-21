package com.seva.mailsender.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.seva.mailsender.exception.DuplicatedElementException;
import com.seva.mailsender.exception.ElementNotFoundException;
import com.seva.mailsender.model.Contact;
import com.seva.mailsender.repo.ContactRepo;
import com.seva.mailsender.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

    private ContactRepo repo;

    public ContactServiceImpl(ContactRepo repo){
        this.repo = repo;
    }

    @Override
    public void delete(Contact contact) {
        repo.delete(contact);
    }

    @Override
    public List<Contact> findAll() {
        return repo.findAll();
    }

    @Override
	public List<Contact> findByNameContaining(String namePattern) {
		return repo.findByNameContaining(namePattern);
	}

    @Override
    public Optional<Contact> findById(String id) throws IllegalArgumentException {
        return repo.findById(id);
    }

    @Override
    public Contact save(Contact contact) {
        return repo.save(contact);
    }

    @Override
	public Contact create(Contact contactIn) throws DuplicatedElementException {
		if (contactIn.getId() != null) {
			Optional<Contact> oContact = findById(contactIn.getId());
			if (oContact.isPresent())
				throw new DuplicatedElementException();
		}
		return repo.save(contactIn);
	}    

    @Override
	public void deleteById(String id) throws ElementNotFoundException {
		Optional<Contact> foundContact = null;
		try {
			foundContact = findById(id);
		} catch (Exception e) {
			throw new ElementNotFoundException();
		}
		if (!foundContact.isPresent())
			throw new ElementNotFoundException();
		delete(foundContact.get());

	}
   
}
