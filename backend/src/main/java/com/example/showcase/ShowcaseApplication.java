package com.example.showcase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class ShowcaseApplication {


    public static void main(String[] args) {
        SpringApplication.run(ShowcaseApplication.class, args);
    }

    
}

//import com.example.showcase.services.INewsletterService;
//

//@SpringBootApplication
//public class ShowcaseApplication implements CommandLineRunner {
//
//    @Autowired
//    private INewsletterService newsletterService;
//
//    public static void main(String[] args) {
//        SpringApplication.run(ShowcaseApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Recupero la lista delle email della newsletter...");
//
//        try {
//            var emails = newsletterService.getAllEmail();
//            System.out.println("Emails trovate: " + emails);
//        } catch (Exception e) {
//            System.err.println("Errore durante il recupero delle email: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//}

