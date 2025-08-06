package com.TecnoNova.gestion_electronicos.modelo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "productos")

public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Integer idProducto;
    private String nombre;
    private String descripcion;
    @Column(name = "nombre_imagen")
    private String nombreImagen;
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "idCategoria")
    private Categoria categoria;
    private double precio;
    private int stock;
    @Column(name = "max_stock")
    private int maxStock;
    private String dimensiones;
    @ManyToOne
    @JoinColumn(name = "id_modelo", referencedColumnName = "idModelo")
    private Modelo modelo;

}
