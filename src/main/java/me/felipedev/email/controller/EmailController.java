package me.felipedev.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.felipedev.email.service.EmailService;

@RestController
@RequestMapping("/email")
@Tag(name = "Email Controller", description = "Endpoints para envio de e-mails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Operation(summary = "Enviar e-mail de texto", description = "Envia um e-mail simples em formato de texto.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "E-mail enviado com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro ao enviar o e-mail")
    })
    @PostMapping("/send-txt")
    public ResponseEntity<String> sendTextEmail(
            @Parameter(description = "E-mail do destinatário", required = true) @RequestParam String recipient,
            @Parameter(description = "Assunto do e-mail", required = true) @RequestParam String subject,
            @Parameter(description = "Conteúdo da mensagem", required = true) @RequestParam String message) {

        String response = emailService.sendMailText(recipient, subject, message);
        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Enviar e-mail em HTML", description = "Envia um e-mail formatado em HTML.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "E-mail enviado com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro ao enviar o e-mail")
    })
    @PostMapping("/send-html")
    public ResponseEntity<String> sendHtmlEmail(
            @Parameter(description = "E-mail do destinatário", required = true) @RequestParam String recipient,
            @Parameter(description = "Assunto do e-mail", required = true) @RequestParam String subject,
            @Parameter(description = "Conteúdo da mensagem em HTML", required = true) @RequestParam String message) {

        String response = emailService.sendMailHtml(recipient, subject, message);
        return ResponseEntity.ok(response);
    }
}
