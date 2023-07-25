package com.example.mutation;

import com.example.request.CreateLogEmailRequest;
import com.example.response.LogEmailResponse;
import com.example.service.LogEmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import graphql.kickstart.tools.GraphQLMutationResolver;


@Service
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	LogEmailService logEmailService;

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	public LogEmailResponse createLogEmail (CreateLogEmailRequest createLogEmailRequest) {
		return new LogEmailResponse(logEmailService.createLogEmail(createLogEmailRequest));
	}

}
