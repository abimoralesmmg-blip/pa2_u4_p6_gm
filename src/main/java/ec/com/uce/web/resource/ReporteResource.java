package ec.com.uce.web.resource;

import java.util.List;

import ec.com.uce.application.service.ReporteService;
import ec.com.uce.domain.model.Reporte;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/reportes")
public class ReporteResource {

    @Inject
    private ReporteService reporteService;


    //el verbo en consulta es get

    // http://localhost:8080/reportes/porId/1
    //http://localhost:8080/reportes/porId/2
    //http://localhost:8080/reportes/porId/15
    @Path ("/porId/{id1}")
    @GET
    public Reporte buscarPorId(@PathParam ("id1") Integer id){
        return this.reporteService.buscarPorId(id);
    }

    @Path ("/todos")
    @GET
    public List <Reporte> buscarTodos (){
        return this.reporteService.buscarTodos();
    }

    // el verbo
    @Path("/guardar")
    @POST
    public void guardar (Reporte reporte){
        this.reporteService.guardar(reporte);
    }

    @Path("/actualizar/{id}")
    @PUT
    public void actualizar (Reporte reporte, @PathParam ("id")Integer id){
        this.reporteService.actualizar(reporte, id);
    }

    @Path("/eliminar/{id}")
    @DELETE
    public void eliminar (@PathParam ("id") Integer id){
        this.reporteService.eliminar(id);
    }

}