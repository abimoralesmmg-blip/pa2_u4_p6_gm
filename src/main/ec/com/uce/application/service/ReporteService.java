package ec.com.uce.application.service;

import java.util.List;

import ec.com.uce.domain.model.Reporte;
import ec.com.uce.infraestructure.repository.ReporteRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ReporteService {


    @Inject
    private ReporteRepositoryImpl reporteRepositoryImpl;

     public List<Reporte> buscarTodos(){
        return (List<Reporte>) this.reporteRepositoryImpl.findAll();
    }

    public Reporte buscarPorId(Integer id) {
        return this.reporteRepositoryImpl.findById(id);
    }

    public void guardar(Reporte reporte) {
        this.reporteRepositoryImpl.persist(reporte);
    }

    public void eliminar(Integer id) {
        this.reporteRepositoryImpl.deleteById(id);
    }

    public void actualizar(Reporte reporteActualizado, Integer id){

        Reporte reporteBase = this.buscarPorId(id); 

        reporteBase.setContenido(reporteActualizado.getContenedor);
        reporteBase.setTitulo(reporteActualizado.getTitulo());
        

        //this.reporteRepositoryImpl.getEntityManager().merge(reporte);
        //no hace falta realizar explicitamente un update. Porque cuando sale del metodo transaccional automaticamente sale de la base de datos.

    }
}