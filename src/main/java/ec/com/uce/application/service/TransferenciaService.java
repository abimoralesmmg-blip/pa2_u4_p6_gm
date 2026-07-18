package ec.com.uce.application.service;

import java.math.BigDecimal;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TransferenciaService {
    @Inject
    private CuentaBancariaService cuentaBancariaService;

    @Inject
    private MailService mailService;

    @Inject
    private AuditoriaService auditoriaService;

    // siempre q sea referencia de dinero es tipo BigDecimal

    public String realizarTransferencia (String cuentaOrigen, String cuentaDestino, BigDecimal monto){
        System.out.println("ID"+ Thread.currentThread().threadId());
        
        
     // identificar los metodos de respuestas de promesas y no quiero esperar hasta q se ejecuta lo demás 
        BigDecimal saldoDestino =this.cuentaBancariaService.agregaMonto(cuentaDestino, monto);
        BigDecimal saldoOrigen =this.cuentaBancariaService.restaMonto(cuentaDestino, monto);


        this.mailService.enviarMail("genemolina@","asunto", "mensaje");
        this.auditoriaService.guardar("Auditoria");
        String mensaje =" Se realizo con exito, su transferencia, su saldo destino es"+ saldoDestino+ "su saldo origen es:"+ saldoOrigen;
    
        
        return mensaje;

    }

    public String realizarTransferenciaReactiva (String cuentaOrigen, String cuentaDestino, BigDecimal monto){
        System.out.println("ID"+ Thread.currentThread().threadId());
        
        
     // identificar los metodos de respuestas de promesas y no quiero esperar hasta q se ejecuta lo demás 
        Uni<BigDecimal> saldoDestino =this.cuentaBancariaService.agregaMontoPromesa(cuentaDestino, monto);
        Uni<BigDecimal> saldoOrigen =this.cuentaBancariaService.restaMontoPromesa(cuentaDestino, monto);

        // metodos q se ejcutan rapido
        this.mailService.enviarMail("genemolina@","asunto", "mensaje");
        this.auditoriaService.guardar("Auditoria");

        // ya debo tener la promesa para el mensaje
        
        Uni.combine().all().unis(saldoDestino,saldoOrigen).asTuple().map(result -> {
            // el result tiene los datos q vienen como promesas q vienen como item
            String mensaje =" Se realizo con exito, su transferencia, su saldo destino es"+ result.getItem1()+ "su saldo origen es:"+ result.getItem2();
            System.out.println(mensaje);

            return mensaje;
        }).toString();

        return "Finalizado";

    }


}
