package com.example;

import com.example.response.EmailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@SpringBootApplication
@EntityScan("com.example.entity")
@EnableJpaRepositories("com.example.repository")
public class GraphQLWithSpringBootApplication {

	@Autowired
	MailSenderService mailService;

	public static void main(String[] args) {
		SpringApplication.run(GraphQLWithSpringBootApplication.class, args);



				String to = "jfga1508@outlook.com";
				String from = "jfga1508@gmail.com";
				String host = "smtp.gmail.com"; // Replace with your SMTP server address
				String username = "jfga1508@gmail.com";
				String password = "unzvluzwtfvcstry";

				Properties properties = new Properties();
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.auth", "true");
				properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS


		Session session = Session.getDefaultInstance(properties, new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
				});

				try {
					MimeMessage message = new MimeMessage(session);
					message.setFrom(new InternetAddress(from));
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
					message.setSubject("Test Email");
					message.setText("This is a test email.");

					Transport.send(message);
					System.out.println("Email sent successfully.");
				} catch (MessagingException mex) {
					mex.printStackTrace();
				}


	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOrigin("http://localhost:3000");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
