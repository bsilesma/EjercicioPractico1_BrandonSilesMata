package com.CFS.demo.service;

import com.CFS.demo.domain.Servicio;
import com.CFS.demo.repository.ReservaRepository;
import com.CFS.demo.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioServiceImpl implements ServicioService {

    private final ServicioRepository servicioRepository;
    private final ReservaRepository reservaRepository;

    @Autowired
    public ServicioServiceImpl(ServicioRepository servicioRepository,
            ReservaRepository reservaRepository) {
        this.servicioRepository = servicioRepository;
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<Servicio> listarTodos() {
        return servicioRepository.findAll();
    }

    @Override
    public Optional<Servicio> buscarPorId(Integer id) {
        return servicioRepository.findById(id);
    }

    @Override
    public List<Servicio> listarPorCategoria(Integer categoriaId) {
        return servicioRepository.findByCategoriaId(categoriaId);
    }

    @Override
    public Servicio guardar(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public void eliminar(Integer id) {
        if (tieneReservasAsociadas(id)) {
            throw new IllegalStateException(
                    "No se puede eliminar el servicio porque tiene reservas asociadas a este");
        }
        servicioRepository.deleteById(id);
    }

    @Override
    public boolean tieneReservasAsociadas(Integer id) {
        return !reservaRepository.findByServicioId(id).isEmpty();
    }
}
