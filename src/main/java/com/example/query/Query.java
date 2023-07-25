package com.example.query;

import com.example.entity.LogEmail;
import com.example.response.LogEmailResponse;
import com.example.service.LogEmailService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class Query implements GraphQLQueryResolver {
	
	@Autowired
	LogEmailService logEmailService;

	private final Logger LOG = LoggerFactory.getLogger(getClass());

	public List<LogEmailResponse> getLogEmails () {
		LOG.info("List all of LogEmail...");
		List<LogEmail> logEmails = logEmailService.getLogEmails();
		List<LogEmailResponse> respon = new ArrayList<>() ;

		for(LogEmail logEmail:logEmails){
			LogEmailResponse logEmailResponse = new LogEmailResponse(logEmail);
			respon.add(logEmailResponse);
		}
		return respon;
	}
}
