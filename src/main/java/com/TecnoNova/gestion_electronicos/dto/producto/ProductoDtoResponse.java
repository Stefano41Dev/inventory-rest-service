package com.TecnoNova.gestion_electronicos.dto.producto;

import com.TecnoNova.gestion_electronicos.dto.categoria.CategoriaDtoResponse;
import com.TecnoNova.gestion_electronicos.dto.modelo.ModeloDtoResponse;
import lombok.Builder;

@Builder
public record ProductoDtoResponse (
    Integer idProducto,
    String nombre,
    String descripcion,
    String urlImagen,
    CategoriaDtoResponse categoria,
    double precio,
    int stock,
    int maxStock,
    String dimensiones,
    ModeloDtoResponse modelo
) {

}
