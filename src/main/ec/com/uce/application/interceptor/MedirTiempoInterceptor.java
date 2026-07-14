package ec.com.uce.interceptor;
import java.time.LocalDateTime;
import java.util.Arrays;
import ec.com.uce.domain.model.Auditoria;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@MedirTiempo
public class MedirTiempoInterceptor {

    @Inject
    private AuditoriaService auditoriaService;

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
        LocalDateTime fechaHoraInicio = LocalDateTime.now();

        Object resultado;
        try {
            
            resultado = context.proceed(); 
        } finally {
            
            long tiempoFin = System.currentTimeMillis();
            long tiempoEjecucionMs = tiempoFin - tiempoInicio;

            
            
            
            Object[] parametros = context.getParameters();
            String argumentosTexto = Arrays.toString(parametros); 

            
            Auditoria auditoria = new Auditoria();
            auditoria.setNombreMetodo(nombreMetodo);
            auditoria.setArgumentos(argumentosTexto);
            auditoria.setFechaHoraEjecucion(fechaHoraInicio);
            auditoria.setTiempoEjecucionMs(tiempoEjecucionMs);

            this.auditoriaService.guardar(auditoria);
    }
    return resultado;

}
}