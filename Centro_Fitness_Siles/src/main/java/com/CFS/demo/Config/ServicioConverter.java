package com.CFS.demo.config;

import com.CFS.demo.domain.Servicio;
import com.CFS.demo.repository.ServicioRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ServicioConverter implements Converter<String, Servicio> {

    private final ServicioRepository servicioRepository;

    public ServicioConverter(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Override
    public Servicio convert(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }
        return servicioRepository.findById(Integer.parseInt(id))
                .orElse(null);
    }
}
