package com.TecnoNova.gestion_electronicos.controlador;

import com.TecnoNova.gestion_electronicos.dto.producto.ProductoDtoRequest;
import com.TecnoNova.gestion_electronicos.dto.producto.ProductoDtoResponse;
import com.TecnoNova.gestion_electronicos.servicios.producto.ProductoServicio;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoControlador {
    private final ProductoServicio productoServicio;

    @GetMapping(value = "/lista")
    public ResponseEntity<Page<ProductoDtoResponse>> listarProductos(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "10") int tamanhioPag
    ) {
        return ResponseEntity.ok(productoServicio.listarProducto(pagina,tamanhioPag));
    }
    @GetMapping(value = "/buscar/{id}")
    public ResponseEntity<ProductoDtoResponse>  buscarProductoPorId(@PathVariable int id) {
        var resultado = productoServicio.buscarProductoPorId(id);
        if (resultado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado) ;
    }
    @PostMapping(value = "/agregar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductoDtoResponse> crearProducto(@RequestPart(value = "producto", required = true) ProductoDtoRequest dto,
                                                             @RequestPart  ("imagen") MultipartFile imagen) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productoServicio.guardarProducto(dto,  imagen));
    }
    @PostMapping(value = "/agregarJson")
    public ResponseEntity<ProductoDtoResponse> crearProductoJson(@RequestBody ProductoDtoRequest dto) {
        MultipartFile file = null;
        return ResponseEntity.status(HttpStatus.CREATED).body(productoServicio.guardarProducto(dto,  file));
    }
    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable int id) {
       productoServicio.eliminarProducto(id);
        return ResponseEntity.ok("Se elimino correctamente");
    }
    @PutMapping(value = "/editar/{id}")
    public ResponseEntity<?> modificarProducto(@RequestBody ProductoDtoRequest dto, @PathVariable Integer id) {
        return ResponseEntity.ok(productoServicio.actualizarProducto(id, dto));
    }
}
