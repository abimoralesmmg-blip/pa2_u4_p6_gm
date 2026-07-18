package ec.com.uce.application.service;

import java.math.BigDecimal;

import ec.com.uce.application.interceptor.MedirTiempo;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class CuentaBancariaService {

    
    @MedirTiempo
    public BigDecimal agregaMonto (String numeroCuenta, BigDecimal monto){
    System.out.println("ID"+ Thread.currentThread().threadId());
     
    try{
    Thread.sleep(2000);
    }catch (InterruptedException e){
        e.printStackTrace();

    }
        BigDecimal saldo = BigDecimal.valueOf(1000);
        saldo =saldo.add(monto);
        return saldo;
    }

    @MedirTiempo
    public BigDecimal restaMonto (String numeroCuenta, BigDecimal monto){

    System.out.println("ID"+ Thread.currentThread().threadId());
        try{
    Thread.sleep(2000);
    }catch (InterruptedException e){
        e.printStackTrace();

    }
        BigDecimal saldo = BigDecimal.valueOf(2000);
        saldo =saldo.subtract(monto);
        return saldo;
    }

    // hacemos programacion reactiva hacemor promesas de promesas
    @MedirTiempo
    public Uni<BigDecimal> agregaMontoPromesa (String numeroCuenta, BigDecimal monto){
        return Uni.createFrom().item(this.agregaMonto(numeroCuenta, monto));
    
    }

    @MedirTiempo
    public Uni<BigDecimal> restaMontoPromesa (String numeroCuenta, BigDecimal monto){
        //return Uni.createFrom().item(this.restaMonto(numeroCuenta, monto));
        return Uni.createFrom().item(()->{
            //todo lo q demora en ejecutar
            return this.restaMonto(numeroCuenta, monto);
        });

    }

}
