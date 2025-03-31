package me.felipedev.email.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	@Value("${spring.mail.username}")
	private String sender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
//	http://localhost:8080/email/send-txt?recipient=luisfelipeadm01@gmail.com&subject=Assunto&message=Olá,%20mundo!
	public String sendMailText(String recipient, String subject, String message) {
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(sender);
			simpleMailMessage.setTo(recipient);
			simpleMailMessage.setSubject(subject);
			simpleMailMessage.setText(message);
			javaMailSender.send(simpleMailMessage);
			return "Microservice: Email Sent";
			
		} catch (Exception e) {
			return "Error to sent email: " + e.getLocalizedMessage();
		}
	}
	
	public String sendMailHtml(String recipient, String subject, String messageContent) {
	    try {
	        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

	        helper.setFrom(sender); // Usa o sender configurado
	        helper.setSubject(subject); // Usa o subject recebido como parâmetro
	        helper.setTo(recipient);

	        String template = loadtemplate();
	        template = template.replace("#{nome}", recipient);
	        template = template.replace("#{message}", messageContent); // Adiciona a mensagem ao template
	        
	        helper.setText(template, true);
	        javaMailSender.send(mimeMessage);
	        return "Microservice: HTML Email Sent";
	    } catch (Exception exception) {
	        System.out.println("Falha ao enviar o email: " + exception.getMessage());
	        return "Error to sent HTML email: " + exception.getLocalizedMessage();
	    }
	}
	
    public String loadtemplate() throws IOException {
        ClassPathResource resource = new ClassPathResource("template-email.html");
        return new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
    }

}
