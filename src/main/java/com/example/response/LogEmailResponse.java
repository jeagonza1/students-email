package com.example.response;

import java.util.Date;

import com.example.entity.LogEmail;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LogEmailResponse {

	private long id;

	private String fullName;

	private String email;
	
	private LogEmail logEmail;


	public LogEmailResponse (LogEmail logEmail) {
		this.logEmail = logEmail;
		this.id = logEmail.getId();
		this.fullName = logEmail.getFullName();
		this.email = logEmail.getEmail();
	}
}
