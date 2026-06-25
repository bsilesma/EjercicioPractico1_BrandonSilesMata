package com.CFS.demo.service;

import com.CFS.demo.domain.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaService {

    List<Categoria> listarTodas();

    Optional<Categoria> buscarPorId(Integer id);

    Categoria guardar(Categoria categoria);

    void eliminar(Integer id);

    boolean tieneServiciosAsociados(Integer id);
}
