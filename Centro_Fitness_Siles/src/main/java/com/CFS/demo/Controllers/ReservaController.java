package com.CFS.demo.controllers;

import com.CFS.demo.domain.Reserva;
import com.CFS.demo.service.ReservaService;
import com.CFS.demo.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    private final ServicioService servicioService;

    @Autowired
    public ReservaController(ReservaService reservaService, ServicioService servicioService) {
        this.reservaService = reservaService;
        this.servicioService = servicioService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", reservaService.listarTodas());
        return "reservas/lista";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNueva(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("servicios", servicioService.listarTodos());
        return "reservas/formulario";
    }

    @PostMapping
    public String guardar(Reserva reserva) {
        reservaService.guardar(reserva);
        return "redirect:/reservas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        reservaService.eliminar(id);
        return "redirect:/reservas";
    }
}
