package com.example.response;

import com.example.entity.Emails;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EmailsResponse {

	private long id;

	private String firstName;

	private String lastName;

	private String email;

	// this is for internal use. DO NOT PUT IN SCHEMA
	private Emails student;

	private String fullName;

	public EmailsResponse(Emails student) {
		this.student = student;
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
	}
}
