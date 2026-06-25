package com.CFS.demo.controllers;

import com.CFS.demo.domain.Categoria;
import com.CFS.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("categorias", categoriaService.listarTodas());
        return "categorias/lista";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNueva(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categorias/formulario";
    }

    @PostMapping
    public String guardar(Categoria categoria) {
        categoriaService.guardar(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Categoria categoria = categoriaService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria no encontrada con id: " + id));
        model.addAttribute("categoria", categoria);
        return "categorias/formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id, Model model) {
        try {
            categoriaService.eliminar(id);
        } catch (IllegalStateException ex) {
            model.addAttribute("categorias", categoriaService.listarTodas());
            model.addAttribute("error", ex.getMessage());
            return "categorias/lista";
        }
        return "redirect:/categorias";
    }
}
