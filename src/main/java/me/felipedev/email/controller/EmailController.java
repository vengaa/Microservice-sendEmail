package me.felipedev.email.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.felipedev.email.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send-txt")
	public ResponseEntity<String> sendTextEmail(
            @RequestParam String recipient,
            @RequestParam String subject,
            @RequestParam String message) {
		
		String response = emailService.sendMailText(recipient, subject, message);
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/send-html")
	public ResponseEntity<String> sendTextHtml(
            @RequestParam String recipient,
            @RequestParam String subject,
            @RequestParam String message) {
		
		String response = emailService.sendMailHtml(recipient, subject, message);
		return ResponseEntity.ok(response);
		
	}	

}
