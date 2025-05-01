package com.TecnoNova.gestion_electronicos.servicios.producto;

import com.TecnoNova.gestion_electronicos.modelo.Producto;
import com.TecnoNova.gestion_electronicos.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServicio implements IProductoServicio {
    @Autowired
    private ProductoRepositorio productoRepositorio;
    @Override
    public void guardarProducto(Producto producto) {
        productoRepositorio.save(producto);
    }

    @Override
    public Producto buscarProductoPorId(int id) {
        Producto producto = productoRepositorio.findById(id).orElse(null);
        return producto;
    }

    @Override
    public void eliminarProducto(Producto producto) {
        productoRepositorio.delete(producto);
    }

    @Override
    public List<Producto> listarProducto() {
        return productoRepositorio.findAll();
    }
}
