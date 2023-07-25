package com.example.query;

import com.example.entity.Emails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.example.response.EmailsResponse;
import com.example.service.EmailsService;

import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.ArrayList;
import java.util.List;


@Component
public class Query implements GraphQLQueryResolver {
	
	@Autowired
	EmailsService emailsService;

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	public EmailsResponse getEmails (long id) {
		LOG.info("Search Emails By id");
		return new EmailsResponse(emailsService.getEmailsById(id));
	}
}
