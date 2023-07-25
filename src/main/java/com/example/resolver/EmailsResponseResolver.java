package com.example.resolver;

import com.example.response.EmailsResponse;
import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailsResponseResolver implements GraphQLResolver<EmailsResponse> {
	
	public String getFullName (EmailsResponse emailsResponse) {
		return emailsResponse.getFirstName() + " " + emailsResponse.getLastName();
	}
}
