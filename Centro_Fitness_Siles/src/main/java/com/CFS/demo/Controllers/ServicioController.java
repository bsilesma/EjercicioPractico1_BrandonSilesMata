package com.CFS.demo.controllers;

import com.CFS.demo.domain.Servicio;
import com.CFS.demo.service.CategoriaService;
import com.CFS.demo.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/servicios")
public class ServicioController {

    private final ServicioService servicioService;
    private final CategoriaService categoriaService;

    @Autowired
    public ServicioController(ServicioService servicioService, CategoriaService categoriaService) {
        this.servicioService = servicioService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("servicios", servicioService.listarTodos());
        return "servicios/lista";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNueva(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "servicios/formulario";
    }

    @PostMapping
    public String guardar(Servicio servicio) {
        servicioService.guardar(servicio);
        return "redirect:/servicios";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Servicio servicio = servicioService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Servicio no encontrado con id: " + id));
        model.addAttribute("servicio", servicio);
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "servicios/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, Model model) {
        try {
            servicioService.eliminar(id);
        } catch (IllegalStateException ex) {
            model.addAttribute("servicios", servicioService.listarTodos());
            model.addAttribute("error", ex.getMessage());
            return "servicios/lista";
        }
        return "redirect:/servicios";
    }
}
