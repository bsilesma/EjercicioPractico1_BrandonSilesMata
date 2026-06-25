package com.CFS.demo.service;

import com.CFS.demo.domain.Reserva;
import java.util.List;
import java.util.Optional;

public interface ReservaService {

    List<Reserva> listarTodas();

    Optional<Reserva> buscarPorId(Integer id);

    Reserva guardar(Reserva reserva);

    void eliminar(Integer id);
}
