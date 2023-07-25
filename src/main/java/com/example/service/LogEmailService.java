package com.example.service;


import com.example.entity.LogEmail;
import com.example.repository.LogEmailRepository;
import com.example.request.CreateLogEmailRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Service
public class LogEmailService {

	@Autowired
	LogEmailRepository logEmailRepository;

	private final Logger LOG = LoggerFactory.getLogger(getClass());
	private final ExecutorService executorService = Executors.newFixedThreadPool(5);


	public LogEmail createLogEmail (CreateLogEmailRequest createLogEmailRequest) {
		LogEmail logemail = new LogEmail(createLogEmailRequest);
		LOG.info("Send email...");
		LOG.info("Name:"+logemail.getFullName()+" email:"+logemail.getEmail() + " Created:"+logemail.getCreated());
		executorService.submit(() -> sendEmail(logemail));
		return logEmailRepository.save(logemail);
	}

	public void sendEmail(LogEmail logemail) {
		String to = logemail.getEmail();
		String from = "jfga1508@gmail.com";
		String host = "smtp.gmail.com"; // Replace with your SMTP server address
		String username = "jfga1508@gmail.com";
		String password = "unzvluzwtfvcstry"; // Replace with your password

		Properties properties = new Properties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Hi " + logemail.getFullName());
			message.setText("Welcome " + logemail.getFullName());

			try (Transport transport = session.getTransport("smtp")) {
				transport.connect(host, username, password);
				transport.sendMessage(message, message.getAllRecipients());
			}

			LOG.info("Email sent successfully.");
		} catch (MessagingException mex) {
			LOG.error("Error sending email: " + mex.getMessage());
		}
	}

	public List<LogEmail> getLogEmails() {
		return logEmailRepository.findAll();
	}
}
