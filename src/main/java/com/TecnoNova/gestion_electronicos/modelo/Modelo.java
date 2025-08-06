package com.TecnoNova.gestion_electronicos.modelo;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "modelos")
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modelo")
    private Integer idModelo;
    @Column(name = "nombre_modelo")
    private String nombreModelo;

    @OneToMany(mappedBy = "modelo")
    private List<Producto> productos;
}
