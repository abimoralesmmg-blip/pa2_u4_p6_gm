package ec.com.uce.web.resource;

import ec.com.uce.application.service.TransferenciaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path ("/transferencia")
public class RecursoTransferencia {

    @Inject
    private TransferenciaService transferenciaService;

    @Path ("/realizar")
    //el verbo hay jerarquia el post, put, delete, get
    @POST
    public String realizarTransferencia (TransferenciaResource transferencia){

        return this.transferenciaService.realizarTransferencia(transferencia.getCuentaOrigen(),transferencia.getCuentaDestino(),transferencia.getMonto());

    }

       @Path ("/realizarReactiva")
    //el verbo hay jerarquia el post, put, delete, get
    @POST
    public String realizarTransferenciaReactiva (TransferenciaResource transferencia){

        return this.transferenciaService.realizarTransferenciaReactiva(transferencia.getCuentaOrigen(),transferencia.getCuentaDestino(),transferencia.getMonto());

    }


}
