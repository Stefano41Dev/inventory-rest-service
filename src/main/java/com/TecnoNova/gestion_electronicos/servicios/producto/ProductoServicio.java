package com.TecnoNova.gestion_electronicos.servicios.producto;

import com.TecnoNova.gestion_electronicos.config.exception.ErrorMensaje;
import com.TecnoNova.gestion_electronicos.dto.producto.ProductoDtoRequest;
import com.TecnoNova.gestion_electronicos.dto.producto.ProductoDtoResponse;
import com.TecnoNova.gestion_electronicos.mapper.producto.ProductoMapper;
import com.TecnoNova.gestion_electronicos.modelo.Producto;
import com.TecnoNova.gestion_electronicos.repositorio.CategoriaRepositorio;
import com.TecnoNova.gestion_electronicos.repositorio.ModeloRepositorio;
import com.TecnoNova.gestion_electronicos.repositorio.ProductoRepositorio;
import com.TecnoNova.gestion_electronicos.servicios.cloudinary.CloudinaryService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class ProductoServicio implements IProductoServicio {

    private final ProductoRepositorio productoRepositorio;
    private final ProductoMapper productoMapper;
    private final CategoriaRepositorio categoriaRepositorio;
    private final ModeloRepositorio modeloRepositorio;
    //para subir imagenes
    private final CloudinaryService cloudinaryService;
    @Override
    public ProductoDtoResponse guardarProducto(ProductoDtoRequest dtoRequest, MultipartFile imagen) {
        Producto producto = productoMapper.dtoRequestToEntity(dtoRequest);
        producto.setCategoria(categoriaRepositorio.findById(dtoRequest.getIdCategoria())
                .orElseThrow(()-> new ErrorMensaje("Categoria no encontrada")));
        producto.setModelo(modeloRepositorio.findById(dtoRequest.getIdModelo())
                .orElseThrow(()-> new ErrorMensaje("Modelo no encontrada")));

        if(imagen != null) {
            producto.setNombreImagen(imagen.getName());
            try{
                cloudinaryService.uploadImage(imagen);
            }catch(Exception e){
                throw new ErrorMensaje(e.getMessage());
            }
        }else{
            producto.setNombreImagen("default.png");
        }
        return productoMapper.entityToDtoResponse(productoRepositorio.save(producto));
    }

    @Override
    public ProductoDtoResponse buscarProductoPorId(Integer id) {
        return productoMapper.entityToDtoResponse(productoRepositorio.findById(id)
                .orElseThrow(()-> new ErrorMensaje("No se encontro el producto")));
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
                .orElseThrow(()-> new ErrorMensaje("Categoria no encontrada")));
        productoActualizar.setModelo(modeloRepositorio.findById(dtoRequest.getIdModelo())
                .orElseThrow(()->new ErrorMensaje("Modelo no encontrada")));
        productoRepositorio.save(productoActualizar);
        return productoMapper.entityToDtoResponse(productoActualizar);
    }


}
