package com.CFS.demo.Config;

import com.CFS.demo.domain.Categoria;
import com.CFS.demo.repository.CategoriaRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CategoriaConverter implements Converter<String, Categoria> {

    private final CategoriaRepository categoriaRepository;

    public CategoriaConverter(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria convert(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }
        return categoriaRepository.findById(Integer.parseInt(id))
                .orElse(null);
    }
}
