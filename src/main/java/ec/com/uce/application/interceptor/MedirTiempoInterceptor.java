package ec.com.uce.application.interceptor;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@MedirTiempo
public class MedirTiempoInterceptor {

    

    @AroundInvoke
    public Object medir(InvocationContext context)throws Exception{



        String nombreMetodo = context.getMethod().getName();
 
        Long tiempoInicio = System.currentTimeMillis();
        System.out.println("Iniciando metodo " + nombreMetodo);
 
        Object result = context.proceed();
 
        Long tiempoFinal = System.currentTimeMillis();
        long tiempo = tiempoFinal - tiempoInicio;
        System.out.println("Tiempo final de ejecucion: " + nombreMetodo + " tiempo " + tiempo + "ms");
 
        return result;

       

}
}