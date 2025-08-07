package com.TecnoNova.gestion_electronicos.mapper.categoria;

import com.TecnoNova.gestion_electronicos.dto.categoria.CategoriaDtoRequest;
import com.TecnoNova.gestion_electronicos.dto.categoria.CategoriaDtoResponse;
import com.TecnoNova.gestion_electronicos.modelo.Categoria;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaMapper {
    public CategoriaDtoResponse entityToDtoResponse(Categoria categoria) {
        return new CategoriaDtoResponse(
                categoria.getIdCategoria(),
                categoria.getNombreCategoria()
        );
    }
    public List<CategoriaDtoResponse> listEntityToListDtoResponse(List<Categoria> categorias) {
        return categorias.stream().map(this::entityToDtoResponse).toList();
    }
    public Categoria DtoRequestToEntity(CategoriaDtoRequest categoriaDtoRequest) {
       Categoria categoria = new Categoria();
       categoria.setNombreCategoria(categoriaDtoRequest.nombre());
        return categoria;
    }

}
