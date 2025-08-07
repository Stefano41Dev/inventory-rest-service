package com.TecnoNova.gestion_electronicos.dto.producto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;
@Getter
@Setter
public class ProductoDtoRequest{
    private String nombre;
    private String descripcion;
    private MultipartFile imagen;
    private Integer idCategoria;
    private double precio;
    private int stock;
    private int maxStock;
    private String dimensiones;
    private Integer idModelo;
}
