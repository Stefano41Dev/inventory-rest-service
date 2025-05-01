package com.TecnoNova.gestion_electronicos.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idModelo")
    private Integer idModelo;
    private String nombreModelo;
    @OneToMany(mappedBy = "modelo")
    private List<Producto> producto;
}
