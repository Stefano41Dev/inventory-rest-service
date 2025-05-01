package com.TecnoNova.gestion_electronicos.controlador;

import com.TecnoNova.gestion_electronicos.modelo.Producto;
import com.TecnoNova.gestion_electronicos.servicios.producto.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin( origins = "http://localhost:4200")
public class ProductoControlador {
    @Autowired
    private ProductoServicio productoServicio;
    @GetMapping(value = "/productos")
    public List<Producto> listarProductos() {
        return productoServicio.listarProducto();
    }
    @GetMapping(value = "/productos/{id}")
    public Producto buscarProductoPorId(@PathVariable int id) {
        return productoServicio.buscarProductoPorId(id);
    }
    @PostMapping(value = "/productos")
    public void crearProducto(@RequestBody Producto producto) {
        productoServicio.guardarProducto(producto);
    }
}
