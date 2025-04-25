package dev.lara.learning.service;

import dev.lara.learning.model.Tarea;
import dev.lara.learning.repository.TareaRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TareaService {
    // private final List<Tarea> tareas = new ArrayList<>();
    // private final AtomicLong contadorId = new AtomicLong(1);
    
    private TareaRepository tareaRepository;
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }
    //Crear tarea
    public Tarea crearTarea(String titulo){
        Tarea tarea = new Tarea(titulo, false);
        return tareaRepository.save(tarea);
    }

    //Obtener todas las tareas
    public List<Tarea> obtenerTodas(){
        return tareaRepository.findAll(); //
    }

    //Marcar como completada
    public Tarea completar(Long id){
        Tarea tarea = tareaRepository.findById(id).orElse(null);
        if(tarea != null){
            tarea.setCompletada(true);
            return tareaRepository.save(tarea); //Actualiza en la DB 
        }
        return null;
    }

    public Tarea eliminar(Long id){
        Tarea tarea = tareaRepository.findById(id).orElse(null);
        if(tarea !=null){
            tareaRepository.delete(tarea);
            return tarea;
        }
        return null;
    }

    // public List<Tarea> filtrar(boolean b){
    //     List<Tarea> lista = new ArrayList<Tarea>();
    //     //Boolean aux = Boolean.parseBoolean(b);
    //     for (Tarea tarea : tareas) {
    //         if(tarea.getCompletada() == b){
    //             lista.add(tarea);
    //         }
    //     }
    //     return lista;
    // }
}
