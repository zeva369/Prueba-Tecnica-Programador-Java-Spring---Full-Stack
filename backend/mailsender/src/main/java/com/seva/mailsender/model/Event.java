package com.seva.mailsender.model;



import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Event {

    private LocalDateTime dateTime;
    private String title;
    private String content;
    private List<Contact> contacts;

    public Event(LocalDateTime dateTime, String title, String content) {
        this.dateTime = dateTime;
        this.title = title;
        this.content = content;
    }

    public void addContact(Contact c) {
        this.contacts.add(c);
    }

    public void removeContact(int i){
        this.contacts.remove(i);
    }

    public void removeContact(Contact c){
        this.contacts.remove(c);
    }

}
