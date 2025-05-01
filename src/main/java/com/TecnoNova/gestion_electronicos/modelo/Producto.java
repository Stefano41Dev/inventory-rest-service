package com.TecnoNova.gestion_electronicos.modelo;
import com.sun.jdi.PrimitiveValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer idProducto;
     private String nombre;
     private String descripcion;
     private String imagen;
     @ManyToOne
     @JoinColumn(name = "idCategoria", referencedColumnName = "idCategoria")
     private Categoria categoria;
     private double precio;
     private int stock;
     private int maxStock;
     private String dimensiones;
     @ManyToOne
     @JoinColumn(name = "idModelo", referencedColumnName = "idModelo")
     private Modelo modelo;

}
