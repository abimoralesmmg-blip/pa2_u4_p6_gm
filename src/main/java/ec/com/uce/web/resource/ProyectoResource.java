package ec.com.uce.web.resource;

import java.util.List;

import ec.com.uce.application.service.ProyectoService;
import ec.com.uce.domain.model.Proyecto;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

@Path("/proyectos")
public class ProyectoResource {

    @Inject
    private ProyectoService proyectoService;


    // http://localhost:8080/proyectos/guardar
    // el verbo
    @Path("/guardar")
    @POST
    public void guardar (Proyecto proyecto){
        this.proyectoService.guardar(proyecto);
    }

    // http://localhost:8080/proyectos/todos
    @Path ("/todos")
    @GET
    public List <Proyecto> buscarTodos (){
        return this.proyectoService.buscarTodos();
    }

    // http://localhost:8080/proyectos/porId/numero
    @Path ("/porId/{id1}")
    @GET
    public Proyecto buscarPorId(@PathParam ("id1") Integer id){
        return this.proyectoService.buscarPorId(id);
    }
   
    // http://localhost:8080/proyectos/actualizar/numeroID
     @Path("/actualizar/{id}")
    @PUT
    public void actualizar (Proyecto proyecto, @PathParam ("id")Integer id){
        this.proyectoService.actualizar(proyecto, id);
    }

    // http://localhost:8080/proyectos/eliminar/numeroID
    @Path("/eliminar/{id}")
    @DELETE
    public void eliminar (@PathParam ("id") Integer id){
        this.proyectoService.eliminar(id);
    }

}
