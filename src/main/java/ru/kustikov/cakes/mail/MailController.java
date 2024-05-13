package ru.kustikov.cakes.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mail")
@RequiredArgsConstructor
public class MailController {
    private final MailSender mailSender;

    @PostMapping("/send-msg")
    public ResponseEntity<String> sendMessage(@RequestBody MailData mailData) {
        mailSender.sendMessage(mailData.email, mailData.text);
        return ResponseEntity.ok("OK");
    }
}
