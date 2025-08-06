package com.TecnoNova.gestion_electronicos.controlador;

import com.TecnoNova.gestion_electronicos.dto.producto.ProductoDtoRequest;
import com.TecnoNova.gestion_electronicos.modelo.Producto;
import com.TecnoNova.gestion_electronicos.repositorio.CategoriaRepositorio;
import com.TecnoNova.gestion_electronicos.repositorio.ModeloRepositorio;
import com.TecnoNova.gestion_electronicos.servicios.producto.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin( origins = "http://localhost:4200")
public class ProductoControlador {
    @Autowired
    private ProductoServicio productoServicio;
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;
    @Autowired
    private ModeloRepositorio modeloRepositorio;
    @GetMapping(value = "/productos")
    public List<Producto> listarProductos() {
        return productoServicio.listarProducto();
    }
    @GetMapping(value = "/productos/{id}")
    public Producto buscarProductoPorId(@PathVariable int id) {
        return productoServicio.buscarProductoPorId(id);
    }
    @PostMapping(value = "/productos")
    public void crearProducto(@RequestBody ProductoDtoRequest dto) {

    }
    @DeleteMapping(value = "/productos/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id) {
       Producto producto = productoServicio.buscarProductoPorId(id);
       if (producto == null) {
           return ResponseEntity.notFound().build();
       }
       productoServicio.eliminarProducto(producto);
       return ResponseEntity.ok("Producto eliminado con éxito");
    }
    @PutMapping(value = "productos/{id}")
    public ResponseEntity<?> modificarProducto(@RequestBody Producto producto, @PathVariable int id) {



        return ResponseEntity.ok("Producto actualizado con exito");
    }
}
