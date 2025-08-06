package com.TecnoNova.gestion_electronicos.dto.producto;

public record ProductoDtoResponse (
    Integer idProducto,
    String nombre,
    String descripcion,
    String nombreImagen,
    String nombreCategoria,
    double precio,
    int stock,
    int maxStock,
    String dimensiones
) {

}
