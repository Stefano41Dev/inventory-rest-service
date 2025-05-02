package com.TecnoNova.gestion_electronicos.controlador;

import com.TecnoNova.gestion_electronicos.modelo.Categoria;
import com.TecnoNova.gestion_electronicos.repositorio.CategoriaRepositorio;
import com.TecnoNova.gestion_electronicos.servicios.categoria.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    @DeleteMapping(value = "/categiria/{id}")
    public ResponseEntity eliminarCategoria(@PathVariable int id) {
       Categoria categoria = categoriaServicio.buscarCategoriaPorId(id);
       if (categoria == null) {
           return ResponseEntity.noContent().build();
       }
       categoriaServicio.eliminarCategoria(categoria);
       return ResponseEntity.ok().build();
    }
    @PutMapping(value = "/categorias/{id}")
    public ResponseEntity actualizarCategoria(@RequestBody Categoria categoria, @PathVariable int id) {
        Categoria categoriaActual = categoriaServicio.buscarCategoriaPorId(id);
        if (categoriaActual == null) {
            return ResponseEntity.noContent().build();
        }
        categoriaActual.setNombre(categoria.getNombre());
        categoriaServicio.agregarCategoria(categoriaActual);
        return ResponseEntity.ok("Categoria actualizada con exito");
    }
}
