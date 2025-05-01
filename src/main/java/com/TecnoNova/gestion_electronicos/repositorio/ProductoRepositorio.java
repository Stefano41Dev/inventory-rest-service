package com.TecnoNova.gestion_electronicos.repositorio;

import com.TecnoNova.gestion_electronicos.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {
}
