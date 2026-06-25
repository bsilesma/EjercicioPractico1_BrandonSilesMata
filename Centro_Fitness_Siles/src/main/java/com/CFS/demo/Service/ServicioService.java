package com.CFS.demo.service;

import com.CFS.demo.domain.Servicio;
import java.util.List;
import java.util.Optional;

public interface ServicioService {

    List<Servicio> listarTodos();

    Optional<Servicio> buscarPorId(Integer id);

    List<Servicio> listarPorCategoria(Integer categoriaId);

    Servicio guardar(Servicio servicio);

    void eliminar(Integer id);

    boolean tieneReservasAsociadas(Integer id);
}
