package com.TecnoNova.gestion_electronicos.servicios.producto;

import com.TecnoNova.gestion_electronicos.dto.producto.ProductoDtoRequest;
import com.TecnoNova.gestion_electronicos.dto.producto.ProductoDtoResponse;
import org.springframework.data.domain.Page;



public interface IProductoServicio {
     ProductoDtoResponse guardarProducto(ProductoDtoRequest dtoRequest);
     ProductoDtoResponse buscarProductoPorId(Integer id);
     void eliminarProducto(Integer id);
     Page<ProductoDtoResponse> listarProducto(int numeroPag,  int tamanhioPag);
}
