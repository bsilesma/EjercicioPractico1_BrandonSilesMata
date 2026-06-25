package com.CFS.demo.service;

import com.CFS.demo.domain.Categoria;
import com.CFS.demo.repository.CategoriaRepository;
import com.CFS.demo.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final ServicioRepository servicioRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository,
            ServicioRepository servicioRepository) {
        this.categoriaRepository = categoriaRepository;
        this.servicioRepository = servicioRepository;
    }

    @Override
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    @Override
    public Optional<Categoria> buscarPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminar(Integer id) {
        if (tieneServiciosAsociados(id)) {
            throw new IllegalStateException(
                    "No se puede eliminar la categoria porque tiene servicios asociados a este");
        }
        categoriaRepository.deleteById(id);
    }

    @Override
    public boolean tieneServiciosAsociados(Integer id) {
        return !servicioRepository.findByCategoriaId(id).isEmpty();
    }
}
