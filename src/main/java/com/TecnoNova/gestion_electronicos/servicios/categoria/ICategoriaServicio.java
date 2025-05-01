package com.TecnoNova.gestion_electronicos.servicios.categoria;

import com.TecnoNova.gestion_electronicos.modelo.Categoria;

import java.util.List;

public interface ICategoriaServicio {
    public void agregarCategoria(Categoria categoria);
    public void eliminarCategoria(Categoria categoria);
    public Categoria buscarCategoriaPorId(int id);
    public List<Categoria> listarCategorias();
}
