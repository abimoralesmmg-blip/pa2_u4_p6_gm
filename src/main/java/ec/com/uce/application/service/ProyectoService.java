package ec.com.uce.application.service;

import java.util.List;

import ec.com.uce.domain.model.Proyecto;
import ec.com.uce.infraestructure.repository.ProyectoRepositoryImpl;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class ProyectoService {

    @Inject 
    private ProyectoRepositoryImpl proyectoRepositoryImpl;

    // crear
    public void guardar(Proyecto proyecto) {
        this.proyectoRepositoryImpl.persist(proyecto);
    }

    // biscar todos
    public List<Proyecto> buscarTodos() {
        return this.proyectoRepositoryImpl.findAll().list();
    }

    // buscar por id
    public Proyecto buscarPorId(Integer id) {
        return this.proyectoRepositoryImpl.findById(id);
    }

    // update
    public void actualizar(Proyecto proyectoActualizado, Integer id) {
        Proyecto proyectoBase = this.buscarPorId(id); 
        
        if (proyectoBase != null) {
            proyectoBase.setNombre(proyectoActualizado.getNombre());
            proyectoBase.setEstado(proyectoActualizado.getEstado());
            proyectoBase.setFechaInicio(proyectoActualizado.getFechaInicio());
        }
    }

    // delete
    public void eliminar(Integer id) {
        this.proyectoRepositoryImpl.deleteById(id);
    }
}