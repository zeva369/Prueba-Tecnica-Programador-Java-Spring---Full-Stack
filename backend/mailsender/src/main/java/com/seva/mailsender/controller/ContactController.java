package com.seva.mailsender.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seva.mailsender.context.ErrMessageConfig;
import com.seva.mailsender.exception.DuplicatedElementException;
import com.seva.mailsender.exception.ElementNotFoundException;
import com.seva.mailsender.exception.MailSenderException;
import com.seva.mailsender.exception.ValidationException;
import com.seva.mailsender.model.Contact;
import com.seva.mailsender.service.ContactService;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
	ErrMessageConfig errMsg;
    
    private ContactService service;

    public ContactController(ContactService service){
        this.service = service;
    }

    @GetMapping
	public List<Contact> findAll(@RequestParam(value = "name", required = false) String name) {
		if (name == null)
			return this.service.findAll();
		return this.service.findByNameContaining(name); //"%" + name + "%");
	}

    @GetMapping("/{id}")
	public ResponseEntity<Contact> findById(@PathVariable String id) {

		Contact foundContact = this.service.findById(id).orElseThrow(
				() -> new MailSenderException(HttpStatus.NOT_FOUND, errMsg.CONTACT_FIND_BY_ID_NOT_FOUND));
        return ResponseEntity.ok(foundContact);
	}

    @PostMapping
    public ResponseEntity<Contact> create(@Valid @RequestBody Contact contactIn, BindingResult result){
        if (result.hasErrors()) {
			throw new ValidationException(result);
		}

        Contact createdContact = null;
		try {
			createdContact = this.service.create(contactIn);
		} catch (DuplicatedElementException e) {
			// Actually this situation can't happen because the contact's id is created
			// dynamically, not supplied by the client
			throw new MailSenderException(HttpStatus.CONFLICT, errMsg.CONTACT_CREATE_DUPLICATED_ELEMENT);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(createdContact);
    }

    // Full update (All fields supplied in the body)
	@PutMapping("/{id}")
	public ResponseEntity<Contact> update(@PathVariable String id, @Valid @RequestBody Contact contactDetails, BindingResult result) {
		if (result.hasErrors()) {
			throw new ValidationException(result);
		}
		
		Contact foundContact = service.findById(id)
				.orElseThrow(() -> new MailSenderException(HttpStatus.NOT_FOUND, errMsg.CONTACT_UPDATE_NOT_FOUND));

		BeanUtils.copyProperties(contactDetails, foundContact);

		Contact savedContact = service.save(foundContact);

		
		return ResponseEntity.status(HttpStatus.OK).body(savedContact);
	}

	// Delete an existing Contact
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable(value = "id") String id) {
		try {
			service.deleteById(id);
		} catch (ElementNotFoundException ex) {
			throw new MailSenderException(HttpStatus.NOT_FOUND, errMsg.CONTACT_DELETE_BY_ID_NOT_FOUND);
		} catch (Exception ex) {
			throw new MailSenderException(HttpStatus.INTERNAL_SERVER_ERROR,
					errMsg.CONTACT_DELETE_CANT_DELETE);
		}
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
	}
}
