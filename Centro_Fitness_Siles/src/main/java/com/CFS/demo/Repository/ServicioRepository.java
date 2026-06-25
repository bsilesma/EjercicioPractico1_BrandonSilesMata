package com.CFS.demo.repository;

import com.CFS.demo.domain.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio, Integer> {

    List<Servicio> findByCategoriaId(Integer categoriaId);
}
