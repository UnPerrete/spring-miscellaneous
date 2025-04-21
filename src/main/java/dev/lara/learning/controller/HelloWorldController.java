package dev.lara.learning.controller;

import dev.lara.learning.service.HelloWorldService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/holamundo")
public class HelloWorldController {
    
    @Autowired
    private HelloWorldService helloWorldService;
/*
 * De esta forma se hace que con la URL:
 * http://localhost:8080/api/holamundo
 * Se acceda directamente al hola mundo sin necesidad de poner más URL
 */
    @GetMapping("") 
    public String helloWorld(){
        return helloWorldService.helloWorld();
    }
/*
 * De esta otra forma se tiene que acceder sí o sí a
 * http://localhost:8080/api/holamundo/saludo
 * para poder ver el holamundo.
 */
    @GetMapping("/saludo") 
    public String helloWorld2(){
        return helloWorldService.helloWorld();
    }
}
