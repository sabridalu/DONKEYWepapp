package com.example.showcase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.showcase.model.Newsletter;
import com.example.showcase.services.INewsletterService;

@RestController
@RequestMapping("/api/newsletter")
public class NewsletterController {

    @Autowired
    private INewsletterService newsletterService;

    @GetMapping("/emails")
    public ResponseEntity<List<String>> getAllNewsletterEmails() {
        List<String> emails = newsletterService.getAllEmail();
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }

    @GetMapping("/email/{id}")
    public ResponseEntity<String> getEmailById(@PathVariable Long id) {
        String email = newsletterService.getEmailById(id);
        return new ResponseEntity<>(email, HttpStatus.OK);
    }
    
    @PostMapping("/email")
    public ResponseEntity<Void> addEmail(@RequestBody String email) {
        newsletterService.addMail(email);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkEmail(@RequestParam String email) {
        boolean exist = newsletterService.checkMail(email);
        return new ResponseEntity<>(exist, HttpStatus.OK);
    }



}
