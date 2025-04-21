package dev.lara.learning.controller;

import dev.lara.learning.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController //Indica que esta clase maneja peticiones HTTP
@RequestMapping("/api/calculadora") //Ruta base
public class CalculadoraController {

    @Autowired //Inyecta automáticamente el servicio, Spring automáticamente pasa una instancia de CalculadoraService al controlador.
    private CalculadoraService calculadoraService;

    @GetMapping("/sumar") //Mapea una ruta /api/calculadora/sumar?a=5&b=3
    public double sumar(@RequestParam double a, @RequestParam double b){
        return calculadoraService.sumar(a, b);
    }

    @GetMapping("/restar")
    public double restar(@RequestParam double a, @RequestParam double b){
        return calculadoraService.restar(a, b);
    }

    @GetMapping("/multiplicar")
    public double multiplicar(@RequestParam double a, @RequestParam double b){
        return calculadoraService.multiplicar(a, b);
    }

    @GetMapping("/dividir")
    public double dividir(@RequestParam double a, @RequestParam double b){
        return calculadoraService.dividir(a, b);
    }
}
