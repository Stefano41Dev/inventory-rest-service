package com.TecnoNova.gestion_electronicos.controlador;

import com.TecnoNova.gestion_electronicos.modelo.Modelo;
import com.TecnoNova.gestion_electronicos.servicios.modelo.ModeloServicio;
import org.springframework.beans.factory.annotation.Autowired;
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
}
