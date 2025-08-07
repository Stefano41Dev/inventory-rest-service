package com.TecnoNova.gestion_electronicos.mapper.producto;

import com.TecnoNova.gestion_electronicos.dto.producto.ProductoDtoRequest;
import com.TecnoNova.gestion_electronicos.dto.producto.ProductoDtoResponse;
import com.TecnoNova.gestion_electronicos.mapper.categoria.CategoriaMapper;
import com.TecnoNova.gestion_electronicos.mapper.modelo.ModeloMapper;
import com.TecnoNova.gestion_electronicos.modelo.Producto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Page;
@Component
@RequiredArgsConstructor
public class ProductoMapper {
    private final CategoriaMapper categoriaMapper;
    private final ModeloMapper modeloMapper;
    public ProductoDtoResponse entityToDtoResponse(Producto producto) {
        return ProductoDtoResponse.builder()
                .idProducto(producto.getIdProducto())
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .nombreImagen(producto.getNombreImagen())
                .categoria(categoriaMapper.entityToDtoResponse(producto.getCategoria()))
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .maxStock(producto.getMaxStock())
                .dimensiones(producto.getDimensiones())
                .modelo(modeloMapper.entityToDtoResponse(producto.getModelo()))
                .build();
    }
    public Producto dtoRequestToEntity(ProductoDtoRequest productoDtoRequest) {
        return Producto.builder()
                .nombre(productoDtoRequest.getNombre())
                .descripcion(productoDtoRequest.getDescripcion())
                .precio(productoDtoRequest.getPrecio())
                .stock(productoDtoRequest.getStock())
                .dimensiones(productoDtoRequest.getDimensiones())
                //categoria
                //modelo se mapean en el service para la busqueda por id
                .build();
    }
    public Page<ProductoDtoResponse> entityToDtoResponsePage(Page<Producto> productos) {
        return productos.map(this::entityToDtoResponse);
    }

}
