package com.chomiko.biblioteca.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String helloWorld(){
        String mensaje = "Sin problema en la configuracion inicial";
        System.out.println(mensaje);
        return mensaje;
    }
}
