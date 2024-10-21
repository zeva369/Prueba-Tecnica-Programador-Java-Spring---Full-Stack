package com.seva.mailsender.context;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// recordemos que la carpeta resources no va al jar final sinó que sus archivos
// quedan en el classpath
@PropertySource("classpath:messages.properties")
public class ErrMessageConfig {
	// Exercise Controller constants
	@Value("${controller.contact.update-partial.not-found}")
	public String CONTACT_UPDATE_PARTIAL_NOT_FOUND;

    @Value("${controller.contact.update-partial.cant-update}")
	public String CONTACT_UPDATE_PARTIAL_CANT_UPDATE;

	@Value("${controller.contact.find-by-id.not-found}")
	public String CONTACT_FIND_BY_ID_NOT_FOUND;

	@Value("${controller.contact.update.cant-update}")
	public String CONTACT_UPDATE_CANT_UPDATE;

	@Value("${controller.contact.update.not-found}")
	public String CONTACT_UPDATE_NOT_FOUND;

	@Value("${controller.contact.create.cant-create}")
	public String CONTACT_CREATE_CANT_CREATE;

	@Value("${controller.contact.create.duplicated-element}")
	public String CONTACT_CREATE_DUPLICATED_ELEMENT;

	@Value("${controller.contact.delete-by-id.not-found}")
	public String CONTACT_DELETE_BY_ID_NOT_FOUND;

	@Value("${controller.contact.delete.cant-delete}")
	public String CONTACT_DELETE_CANT_DELETE;

}