package ec.com.uce.application.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class MailService {

    public void enviarMail (String destino, String asuntO, String cuerpo){
    System.out.println("ID"+ Thread.currentThread().threadId());
        try{
    Thread.sleep(2000);
    }catch (InterruptedException e){
        e.printStackTrace();

    }
        System.out.println("Se eenvia un mail"+ destino);
    }

}
