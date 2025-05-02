package com.TecnoNova.gestion_electronicos.controlador;

import com.TecnoNova.gestion_electronicos.modelo.Modelo;
import com.TecnoNova.gestion_electronicos.servicios.modelo.ModeloServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin( origins = "http://localhost:4200")
public class ModeloControlador {
    @Autowired
    private ModeloServicio modeloServicio;
    @GetMapping(value = "/modelos")
    public List<Modelo> listarModelos() {
        return modeloServicio.listaModelos();
    }
    @GetMapping(value = "/modelos/{id}")
    public Modelo buscarModeloPorId(@PathVariable int id) {
        return modeloServicio.buscarModelo(id);
    }
    @PostMapping(value = "/modelos")
    public void guardarModelo(@RequestBody Modelo modelo) {
        modeloServicio.guardarModelo(modelo);
    }
    @DeleteMapping(value = "/modelos/{id}")
    public ResponseEntity<?> eliminarModelo(@PathVariable int id) {
        Modelo modelo = modeloServicio.buscarModelo(id);
        if (modelo == null) {
            return ResponseEntity.notFound().build();
        }
        modeloServicio.eliminarModelo(modelo);
        return ResponseEntity.ok("Modelo eliminado exitosamente");
    }
    @PutMapping(value = "/modelos/{id}")
    public ResponseEntity<?> modificarModelo(@RequestBody Modelo modelo, @PathVariable int id) {
        Modelo modeloActual = modeloServicio.buscarModelo(id);
        if (modeloActual == null) {
            return ResponseEntity.notFound().build();
        }
        modeloActual.setNombreModelo(modelo.getNombreModelo());
        modeloServicio.guardarModelo(modelo);
        return ResponseEntity.ok("Modelo modificado exitosamente");
    }
}
