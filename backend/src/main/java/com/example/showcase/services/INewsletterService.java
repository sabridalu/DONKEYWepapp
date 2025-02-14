package com.example.showcase.services;

import java.util.List;

import com.example.showcase.model.Newsletter;

public interface INewsletterService {
	
	public List<String> getAllEmail();
	
    public String getEmailById(Long id);

    public boolean checkMail(String email);

    public void addMail(String email);
}
