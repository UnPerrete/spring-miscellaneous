package dev.lara.learning.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Tarea {
    @Id //Marca el campo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-incremental
    private Long id;
    private String titulo;
    private boolean completada;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion = new Date();

    //Constructor vacío (obligatorio para JPA)
    public Tarea(){}
    
    //Los getters y los setters son obligatorios para JPA

    public Tarea(String titulo, boolean completada){
        this.titulo = titulo;
        this.completada = completada;
    }

    public void setId(Long id){
        this.id = id;
        
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean getCompletada(){
        return completada;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
}
