package com.example.service;

import com.example.entity.Emails;
import com.example.repository.EmailsRepository;
import com.example.request.CreateEmailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailsService {

	@Autowired
	EmailsRepository emailsRepository;

	private Long id;

	public Emails getEmailsById (long id) {
		return emailsRepository.findById(id).get();
	}
	
	public Emails createEmails (CreateEmailsRequest createEmailsRequest) {
		Emails emails = new Emails(createEmailsRequest);
		
		emails = emailsRepository.save(emails);
		
		return emails;
	}

	public Boolean deleteEmails (Long id) {
		this.id = id;
		Emails emails = emailsRepository.getById(id);

		emailsRepository.deleteById(id);
		return true;
	}
}
