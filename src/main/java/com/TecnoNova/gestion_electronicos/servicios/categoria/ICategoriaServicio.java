package com.TecnoNova.gestion_electronicos.servicios.categoria;

import com.TecnoNova.gestion_electronicos.dto.categoria.CategoriaDtoRequest;
import com.TecnoNova.gestion_electronicos.dto.categoria.CategoriaDtoResponse;
import java.util.List;

public interface ICategoriaServicio {
    CategoriaDtoResponse agregarCategoria(CategoriaDtoRequest categoria);
    void eliminarCategoria(Integer id);
    CategoriaDtoResponse buscarCategoriaPorId(Integer id);
    CategoriaDtoResponse actualizarCategoria(Integer id, CategoriaDtoRequest categoria);
    List<CategoriaDtoResponse> listarCategorias();
}
