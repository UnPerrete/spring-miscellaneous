package dev.lara.learning.controller;

import dev.lara.learning.model.Tarea;
import dev.lara.learning.service.TareaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Indica que la clase maneja peticiones HTTP
@RequestMapping("/api/tareas") //Ruta
public class TareaController {

    @Autowired //Inyecta automáticamente el servicio, Spring automáticamente pasa una instancia de CalculadoraService al controlador.
    private TareaService tareaService;

    //POST: Crear una tarea
    @PostMapping
    public Tarea crearTarea(@RequestBody String titulo){
        return tareaService.crearTarea(titulo);
    }

    //GET: Obtener las tareas
    @GetMapping
    public List<Tarea> obtenerTareas(){
        return tareaService.obtenerTodas();
    }

    // @GetMapping("/{b}/filtrar")
    // public List<Tarea> filtrarTareas(@PathVariable boolean b){
    //     return tareaService.filtrar(b);
    // }

    //PUT: Marcar tarea como completada
    @PutMapping("/{id}/completar")
    public Tarea completarTarea(@PathVariable Long id){
        return tareaService.completar(id);
    }

    @DeleteMapping("/{id}/")
    public Tarea borrarTarea(@PathVariable Long id){
        return tareaService.eliminar(id);
    }
}