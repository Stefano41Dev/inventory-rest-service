package com.TecnoNova.gestion_electronicos.controlador;

import com.TecnoNova.gestion_electronicos.modelo.Categoria;
import com.TecnoNova.gestion_electronicos.repositorio.CategoriaRepositorio;
import com.TecnoNova.gestion_electronicos.servicios.categoria.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin( origins = "http://localhost:4200")
public class CategoriaControlador {
    //esto es un controlador
    @Autowired
    private CategoriaServicio categoriaServicio;
    @GetMapping(value = "/categoria")
    public List<Categoria> listar() {
        return categoriaServicio.listarCategorias();
    }
    @GetMapping(value = "/categoria/{id}")
    public Categoria buscarCategoriaPorId(@PathVariable int id) {
        return categoriaServicio.buscarCategoriaPorId(id);
    }
    @PostMapping(value = "/categoria")
    public void guardarCategoria(@RequestBody Categoria categoria) {
        categoriaServicio.agregarCategoria(categoria);
    }

}
