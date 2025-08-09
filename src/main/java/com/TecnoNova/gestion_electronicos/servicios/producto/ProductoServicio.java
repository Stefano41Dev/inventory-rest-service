package com.TecnoNova.gestion_electronicos.servicios.producto;

import com.TecnoNova.gestion_electronicos.dto.producto.ProductoDtoRequest;
import com.TecnoNova.gestion_electronicos.dto.producto.ProductoDtoResponse;
import com.TecnoNova.gestion_electronicos.mapper.producto.ProductoMapper;
import com.TecnoNova.gestion_electronicos.modelo.Producto;
import com.TecnoNova.gestion_electronicos.repositorio.CategoriaRepositorio;
import com.TecnoNova.gestion_electronicos.repositorio.ModeloRepositorio;
import com.TecnoNova.gestion_electronicos.repositorio.ProductoRepositorio;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProductoServicio implements IProductoServicio {

    private final ProductoRepositorio productoRepositorio;
    private final ProductoMapper productoMapper;
    private final CategoriaRepositorio categoriaRepositorio;
    private final ModeloRepositorio modeloRepositorio;
    @Override
    public ProductoDtoResponse guardarProducto(ProductoDtoRequest dtoRequest) {
        Producto producto = productoMapper.dtoRequestToEntity(dtoRequest);
        producto.setCategoria(categoriaRepositorio.findById(dtoRequest.getIdCategoria())
                .orElseThrow(()-> new RuntimeException("Categoria no encontrada")));
        producto.setModelo(modeloRepositorio.findById(dtoRequest.getIdModelo())
                .orElseThrow(()-> new RuntimeException("Modelo no encontrada")));

        return productoMapper.entityToDtoResponse(productoRepositorio.save(producto));
    }

    @Override
    public ProductoDtoResponse buscarProductoPorId(Integer id) {
        return productoMapper.entityToDtoResponse(productoRepositorio.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el producto")));
    }

    @Override
    public void eliminarProducto(Integer id) {
        productoRepositorio.deleteById(id);
    }

    @Override
    public Page<ProductoDtoResponse> listarProducto(int numeroPag, int tamanhioPag) {
        Pageable pageable = PageRequest.of(numeroPag, tamanhioPag);
        return productoMapper.entityToDtoResponsePage(productoRepositorio.findAll(pageable));
    }

    @Override
    public ProductoDtoResponse actualizarProducto(Integer id, ProductoDtoRequest dtoRequest) {
        Producto productoActualizar = productoRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Producto no encontrado"));

        productoActualizar.setNombre(dtoRequest.getNombre());
        productoActualizar.setDescripcion(dtoRequest.getDescripcion());
        productoActualizar.setPrecio(dtoRequest.getPrecio());
        productoActualizar.setStock(dtoRequest.getStock());
        productoActualizar.setMaxStock(dtoRequest.getMaxStock());
        productoActualizar.setDimensiones(dtoRequest.getDimensiones());
        productoActualizar.setCategoria(categoriaRepositorio.findById(dtoRequest.getIdCategoria())
                .orElseThrow(()-> new RuntimeException("Categoria no encontrada")));
        productoActualizar.setModelo(modeloRepositorio.findById(dtoRequest.getIdModelo())
                .orElseThrow(()->new RuntimeException("Modelo no encontrada")));
        productoRepositorio.save(productoActualizar);
        return productoMapper.entityToDtoResponse(productoActualizar);
    }
}
