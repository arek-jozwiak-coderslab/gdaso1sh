package pl.coderslab.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmail(){
        System.out.println("wysyłam email");
    }
}
