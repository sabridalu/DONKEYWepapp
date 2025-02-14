package com.example.showcase.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.showcase.model.Newsletter;
import com.example.showcase.repository.INewsletterRepository;
import com.example.showcase.services.INewsletterService;

import jakarta.transaction.Transactional;

@Service
public class NewsletterService implements  INewsletterService {

	 @Autowired
	    private INewsletterRepository newsletterRepository;

	    @Override
	    public List<String> getAllEmail() {
	    	return newsletterRepository.findAllEmails();
	    }	    

	    @Override
	    public String getEmailById(Long id) {
	        return newsletterRepository.findEmailById(id);
	    }

	    @Override
	    public boolean checkMail(String email) {
	        return !newsletterRepository.findByEmail(email).isEmpty();
	    }
	    
	    
	    @Override
	    public void addMail(String email) {
	    	try {  
	    	  if (!checkMail(email)) {
	            Newsletter newEntry = new Newsletter();
	            newEntry.setEmail(email);
	            newsletterRepository.save(newEntry);
	            }
	    	  } 
	    	catch (Exception e) 
	    	{
	    		e.printStackTrace();
	    		System.out.println("Non è stato possibile aggiungere l' email: " + email);
	    	        
	    	    }
	    }		    
	    
}

