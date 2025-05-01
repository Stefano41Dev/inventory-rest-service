package com.TecnoNova.gestion_electronicos.servicios.categoria;

import com.TecnoNova.gestion_electronicos.modelo.Categoria;
import com.TecnoNova.gestion_electronicos.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServicio implements ICategoriaServicio {
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    @Override
    public void agregarCategoria(Categoria categoria) {
        categoriaRepositorio.save(categoria);
    }

    @Override
    public void eliminarCategoria(Categoria categoria) {
        categoriaRepositorio.delete(categoria);
    }

    @Override
    public Categoria buscarCategoriaPorId(int id) {
        return categoriaRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepositorio.findAll();
    }
}
