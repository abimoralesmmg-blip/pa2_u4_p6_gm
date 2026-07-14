package ec.com.uce.Web.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.Path;

@Path ("/reportes")
public class ReporteResource {

    @Inject
    private ReporteService reporteService;

    public Reporte buscarPorId(Integer id){
        return this.reporteService.buscarPorId(id);
    }

}