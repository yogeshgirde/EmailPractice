package com.app.util;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class AppMailSender {
	@Autowired
	private JavaMailSender mailsender;

	public boolean sendMail(String to,String subject,String text,FileSystemResource file) {
		boolean status=false;
		try {
         MimeMessage meassage=mailsender.createMimeMessage();
         MimeMessageHelper helper=new MimeMessageHelper(meassage,file !=null?true:false);
         helper.setTo(to);
         helper.setSubject(subject);
         helper.setText(text);
         helper.setFrom("yogish2904@gmail.com");
         helper.addAttachment(file.getFilename(), file);
         mailsender.send(meassage);
         status=true;
		} catch (Exception e) {
         status =false;
         e.printStackTrace();
		}
		return status;
	}
}
