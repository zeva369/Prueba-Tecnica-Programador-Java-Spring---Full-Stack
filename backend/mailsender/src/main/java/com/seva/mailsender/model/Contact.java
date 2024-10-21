package com.seva.mailsender.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// import jakarta.persistence.Column;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Contact {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @NotBlank(message = "{NotBlank.contact.name}")
	//@Column(nullable = false)
    private String name;

    @NotBlank(message = "{NotBlank.contact.surname}")
	//@Column(nullable = false)
    private String surname;

    @NotBlank(message = "{NotBlank.contact.email}")
	//@Column(nullable = false)
    private String email;
    
    private GENDER gender;
    private String address;
 

}
