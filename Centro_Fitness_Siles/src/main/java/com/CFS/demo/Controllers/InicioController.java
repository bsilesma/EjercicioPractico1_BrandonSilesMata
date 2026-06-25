package com.CFS.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InicioController {

    @GetMapping("/")
    public String inicio() {
        return "inicio";
    }

    @GetMapping("/contacto")
    public String mostrarContacto() {
        return "contacto";
    }

    @PostMapping("/contacto")
    public String enviarContacto(@RequestParam String nombre,
            @RequestParam String correo,
            @RequestParam String mensaje) {
        // Solo interfaz: no hay persistencia en base de datos, segun el enunciado.
        return "redirect:/contacto?enviado";
    }
}
