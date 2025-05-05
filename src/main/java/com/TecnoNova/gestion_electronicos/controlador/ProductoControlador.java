package com.TecnoNova.gestion_electronicos.controlador;

import com.TecnoNova.gestion_electronicos.dto.ProductoDto;
import com.TecnoNova.gestion_electronicos.modelo.Producto;
import com.TecnoNova.gestion_electronicos.repositorio.CategoriaRepositorio;
import com.TecnoNova.gestion_electronicos.repositorio.ModeloRepositorio;
import com.TecnoNova.gestion_electronicos.servicios.categoria.CategoriaServicio;
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
    public void crearProducto(@RequestBody ProductoDto dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setImagen(dto.getImagen());
        producto.setCategoria(categoriaRepositorio.findById(dto.getId_categoria()).orElse(null));
        producto.setModelo(modeloRepositorio.findById(dto.getId_modelo()).orElse(null));
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setMaxStock(dto.getMaxStock());
        producto.setDimensiones(dto.getDimensiones());
        productoServicio.guardarProducto(producto);
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
        Producto productoActual = productoServicio.buscarProductoPorId(id);
        if (productoActual == null) {
            return ResponseEntity.notFound().build();
        }
        productoActual.setNombre(producto.getNombre());
        productoActual.setDescripcion(producto.getDescripcion());
        productoActual.setImagen(producto.getImagen());
        productoActual.setCategoria(producto.getCategoria());
        productoActual.setPrecio(producto.getPrecio());
        productoActual.setStock(producto.getStock());
        productoActual.setMaxStock(producto.getMaxStock());
        productoActual.setDescripcion(producto.getDescripcion());
        productoActual.setModelo(producto.getModelo());

        productoServicio.guardarProducto(productoActual);
        return ResponseEntity.ok("Producto actualizado con exito");
    }
}
