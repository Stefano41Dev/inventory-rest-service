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
    @Column(name = "url_imagen")
    private String urlImagen;
    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private Categoria categoria;
    private double precio;
    private int stock;
    @Column(name = "max_stock")
    private int maxStock;
    private String dimensiones;
    @ManyToOne
    @JoinColumn(name = "id_modelo", referencedColumnName = "id_modelo")
    private Modelo modelo;


}
