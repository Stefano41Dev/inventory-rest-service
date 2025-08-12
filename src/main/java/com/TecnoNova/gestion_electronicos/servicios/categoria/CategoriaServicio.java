package com.TecnoNova.gestion_electronicos.servicios.categoria;

import com.TecnoNova.gestion_electronicos.dto.categoria.CategoriaDtoRequest;
import com.TecnoNova.gestion_electronicos.dto.categoria.CategoriaDtoResponse;
import com.TecnoNova.gestion_electronicos.mapper.categoria.CategoriaMapper;
import com.TecnoNova.gestion_electronicos.modelo.Categoria;
import com.TecnoNova.gestion_electronicos.repositorio.CategoriaRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoriaServicio implements ICategoriaServicio {
    private final CategoriaRepositorio categoriaRepositorio;
    private final CategoriaMapper categoriaMapper;
    @Override
    public CategoriaDtoResponse agregarCategoria(CategoriaDtoRequest dtoRequest) {
        Categoria categoria = categoriaMapper.DtoRequestToEntity(dtoRequest);
        categoriaRepositorio.save(categoria);
        return categoriaMapper.entityToDtoResponse(categoria);
    }

    @Override
    public void eliminarCategoria(Integer id) {
        categoriaRepositorio.deleteById(id);
    }

    @Override
    public CategoriaDtoResponse buscarCategoriaPorId(Integer id) {
        return categoriaMapper.entityToDtoResponse(categoriaRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("No se se encontro la categoria con " + id)));
    }

    @Override
    public CategoriaDtoResponse actualizarCategoria(Integer id, CategoriaDtoRequest dtoRequest) {
        Categoria categoria = categoriaRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro la categoria con " + id));
        categoria.setNombreCategoria(dtoRequest.nombre());
        categoriaRepositorio.save(categoria);
        return categoriaMapper.entityToDtoResponse(categoria);
    }

    @Override
    public List<CategoriaDtoResponse> listarCategorias() {
        return categoriaMapper.listEntityToListDtoResponse(categoriaRepositorio.findAll());
    }
}
