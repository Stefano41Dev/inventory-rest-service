package com.TecnoNova.gestion_electronicos.repositorio;

import com.TecnoNova.gestion_electronicos.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer> {
}
