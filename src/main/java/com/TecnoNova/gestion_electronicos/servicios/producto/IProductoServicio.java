package com.TecnoNova.gestion_electronicos.servicios.producto;

import com.TecnoNova.gestion_electronicos.modelo.Producto;

import java.util.List;

public interface IProductoServicio {
    public void guardarProducto(Producto producto);
    public Producto buscarProductoPorId(int id);
    public void eliminarProducto(Producto producto);
    public List<Producto> listarProducto();
}
