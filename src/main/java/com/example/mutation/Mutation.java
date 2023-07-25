package com.example.mutation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.request.CreateEmailsRequest;
import com.example.response.EmailsResponse;
import com.example.service.EmailsService;

import graphql.kickstart.tools.GraphQLMutationResolver;


@Service
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	EmailsService emailsService;

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	public EmailsResponse createEmails (CreateEmailsRequest createEmailsRequest) {
		LOG.info("Create a Emails...");
		return new EmailsResponse(emailsService.createEmails(createEmailsRequest));
	}

	public Boolean  deleteEmails (Long id) {
		LOG.info("Delete Emails "+id);
		emailsService.deleteEmails(id);
		return true;
	}
}
