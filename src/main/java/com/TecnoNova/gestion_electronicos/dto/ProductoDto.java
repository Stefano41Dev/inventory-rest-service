package com.TecnoNova.gestion_electronicos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ProductoDto {
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Integer id_categoria;
    private double precio;
    private int stock;
    private int maxStock;
    private String dimensiones;
    private Integer id_modelo;
}
