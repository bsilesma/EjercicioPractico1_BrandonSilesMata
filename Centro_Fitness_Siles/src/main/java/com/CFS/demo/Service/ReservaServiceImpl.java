package com.CFS.demo.service;

import com.CFS.demo.domain.Reserva;
import com.CFS.demo.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Override
    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> buscarPorId(Integer id) {
        return reservaRepository.findById(id);
    }

    @Override
    public Reserva guardar(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public void eliminar(Integer id) {
        reservaRepository.deleteById(id);
    }
}
