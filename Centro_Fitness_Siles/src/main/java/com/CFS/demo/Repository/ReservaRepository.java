package com.CFS.demo.repository;

import com.CFS.demo.domain.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    List<Reserva> findByServicioId(Integer servicioId);
}
