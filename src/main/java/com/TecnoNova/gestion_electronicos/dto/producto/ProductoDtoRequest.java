package com.TecnoNova.gestion_electronicos.dto.producto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDtoRequest {
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Integer idCategoria;
    private double precio;
    private int stock;
    private int maxStock;
    private String dimensiones;
    private Integer idModelo;
}
