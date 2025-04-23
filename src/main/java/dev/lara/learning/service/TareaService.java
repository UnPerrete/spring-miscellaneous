package dev.lara.learning.service;

import dev.lara.learning.model.Tarea;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TareaService {
    private final List<Tarea> tareas = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(1);

    //Crear tarea
    public Tarea crearTarea(String titulo){
        Tarea tarea = new Tarea(contadorId.getAndIncrement(), titulo, false);

        tareas.add(tarea);
        return tarea;
    }

    //Obtener todas las tareas
    public List<Tarea> obtenerTodas(){
        return tareas;
    }

    //Marcar como completada
    public Tarea completar(Long id){
        Tarea tarea = tareas.stream()
            .filter(t -> t.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));

        tarea.setCompletada(true);
        return tarea;
    }

    public Tarea eliminar(Long id){
        Tarea tarea = tareas.stream()
            .filter(t -> t.getId().equals(id))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Tarea no encontrada con ID: " + id));

        tareas.remove(tarea);
        return tarea;
    }

    public List<Tarea> filtrar(boolean b){
        List<Tarea> lista = new ArrayList<Tarea>();
        //Boolean aux = Boolean.parseBoolean(b);
        for (Tarea tarea : tareas) {
            if(tarea.getCompletada() == b){
                lista.add(tarea);
            }
        }
        return lista;
    }
}
