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

    public void guardar(Reporte reporte){
        this.reporteRepositoryImpl.persist(reporte);
    }

    public List<Reporte> buscarTodos(){
        //return (List<Reporte>) this.reporteRepositoryImpl.findAll();
        return this.reporteRepositoryImpl.findAll().list();
    }

    public Reporte buscarPorId(Integer id){
        return this.reporteRepositoryImpl.findById(id);
    }

    public void actualizar(Reporte reporteActualizado, Integer id){

        Reporte reporteBase = this.buscarPorId(id); 

        reporteBase.setNombre(reporteActualizado.getNombre());
        reporteBase.setEstado(reporteActualizado.getEstado());
        reporteBase.setFechaGeneracion(reporteActualizado.getFechaGeneracion());
        
    }

    public void actualizar2(Reporte reporte, Integer id){

        Reporte reporteBase = this.buscarPorId(reporte.getId());
    }

    public void eliminar(Integer id){
        this.reporteRepositoryImpl.deleteById(id);
    }

    

}