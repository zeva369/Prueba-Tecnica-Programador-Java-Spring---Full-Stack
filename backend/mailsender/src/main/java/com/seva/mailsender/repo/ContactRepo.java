package com.seva.mailsender.repo;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.querydsl.QuerydslPredicateExecutor;
//import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.seva.mailsender.model.Contact;

@Repository
public interface ContactRepo extends MongoRepository<Contact, String>{
    //@Query("{ 'name' : { $regex: ?0, $options: 'i' } }")
    public List<Contact> findByNameContaining(String name);
}
