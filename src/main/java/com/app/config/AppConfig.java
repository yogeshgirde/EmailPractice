package com.app.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
@ComponentScan(basePackages= {"com.app"})
public class AppConfig {
      @Bean
	public JavaMailSenderImpl mailsender() {
		JavaMailSenderImpl mail=new JavaMailSenderImpl();
		mail.setHost("smtp.gmail.com");
		mail.setPort(587);
		mail.setUsername("yogish2904@gmail.com");
		mail.setPassword("sharingan@29");
		mail.setJavaMailProperties(getMailProps());
		return mail;
	}

	public Properties getMailProps() {
		Properties p=new Properties();
		p.put("mail.smtp.auth","true");
		p.put("mail.smtp.starttls.enable","true");
		return p;
	}
}
