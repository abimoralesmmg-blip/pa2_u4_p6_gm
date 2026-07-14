package ec.com.uce.domain.model;

import java.time.LocalDate;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "reporte" )
public class Reporte extends PanacheEntityBase {
    @Id
    @SequenceGenerator(name = "seq_reporte_generator", sequenceName = "seq_reporte", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_reporte_generator")
    @Column(name = "repo_id")
    private Integer id;
    @Column(name = "repo_nombre")
    private String nombre;
    @Column(name = "repo_estado")
    private String estado;
    @Column(name = "repo_fecha_generacion")
    private LocalDate fechaGeneracion;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }
    public void setFechaGeneracion(LocalDate fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    

}