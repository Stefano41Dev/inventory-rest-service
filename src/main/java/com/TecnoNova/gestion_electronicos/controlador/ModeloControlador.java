package com.TecnoNova.gestion_electronicos.controlador;


import com.TecnoNova.gestion_electronicos.dto.modelo.ModeloDtoRequest;
import com.TecnoNova.gestion_electronicos.dto.modelo.ModeloDtoResponse;
import com.TecnoNova.gestion_electronicos.servicios.modelo.ModeloServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ModeloControlador {
    private final ModeloServicio modeloServicio;
    @GetMapping(value = "/modelos")
    public ResponseEntity<List<ModeloDtoResponse>> listarModelos() {
        return ResponseEntity.ok(modeloServicio.listaModelos());
    }
    @GetMapping(value = "/modelos/{id}")
    public ResponseEntity<ModeloDtoResponse> buscarModeloPorId(@PathVariable int id) {
        ModeloDtoResponse resultado = modeloServicio.buscarModelo(id);
        if(resultado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultado);
    }
    @PostMapping(value = "/modelos")
    public ResponseEntity<ModeloDtoResponse> guardarModelo(@RequestBody ModeloDtoRequest dtoRequest) {
       return ResponseEntity.status(HttpStatus.CREATED).body(modeloServicio.guardarModelo(dtoRequest));
    }
    @DeleteMapping(value = "/modelos/{id}")
    public ResponseEntity<?> eliminarModelo(@PathVariable int id) {
        modeloServicio.eliminarModelo(id);
        return ResponseEntity.ok("Modelo eliminado exitosamente");
    }
    @PutMapping(value = "/modelos/{id}")
    public ResponseEntity<ModeloDtoResponse> modificarModelo(@RequestBody ModeloDtoRequest dtoRequest, @PathVariable int id) {
        return ResponseEntity.ok(modeloServicio.modificarModelo(id, dtoRequest));
    }
}
