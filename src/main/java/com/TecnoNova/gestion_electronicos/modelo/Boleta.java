package com.TecnoNova.gestion_electronicos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class Boleta {
    @Id
    private int numeroBoleta;
    private Date fecha;
    private String descripcion;
    @OneToOne
    private Cliente cliente;
}
