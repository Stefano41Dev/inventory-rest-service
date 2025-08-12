package com.TecnoNova.gestion_electronicos.controlador;

import com.TecnoNova.gestion_electronicos.dto.categoria.CategoriaDtoRequest;
import com.TecnoNova.gestion_electronicos.dto.categoria.CategoriaDtoResponse;
import com.TecnoNova.gestion_electronicos.servicios.categoria.CategoriaServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoriaControlador {
    private final CategoriaServicio categoriaServicio;
    @GetMapping(value = "/categoria")
    public ResponseEntity<List<CategoriaDtoResponse>> listar() {
        return ResponseEntity.ok(categoriaServicio.listarCategorias());
    }
    @GetMapping(value = "/categoria/{id}")
    public ResponseEntity<CategoriaDtoResponse> buscarCategoriaPorId(@PathVariable int id) {
        return ResponseEntity.ok(categoriaServicio.buscarCategoriaPorId(id));
    }
    @PostMapping(value = "/categoria")
    public ResponseEntity<CategoriaDtoResponse> guardarCategoria(@RequestBody CategoriaDtoRequest dto) {
        return ResponseEntity.ok(categoriaServicio.agregarCategoria(dto));
    }
    @DeleteMapping(value = "/categiria/{id}")
    public ResponseEntity<?> eliminarCategoria(@PathVariable int id) {
       CategoriaDtoResponse categoria = categoriaServicio.buscarCategoriaPorId(id);
       if (categoria == null) {
           return ResponseEntity.noContent().build();
       }
       categoriaServicio.eliminarCategoria(categoria.idCategoria());
       return ResponseEntity.ok("Se elimino correctamente la categoria " + categoria.nombre());
    }
    @PutMapping(value = "/categorias/{id}")
    public ResponseEntity<CategoriaDtoResponse> actualizarCategoria(@RequestBody CategoriaDtoRequest categoria, @PathVariable int id) {
        CategoriaDtoResponse categoriaActual = categoriaServicio.buscarCategoriaPorId(id);
        if (categoriaActual == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categoriaServicio.actualizarCategoria(id, categoria));
    }
}
