package com.TecnoNova.gestion_electronicos.servicios.modelo;

import com.TecnoNova.gestion_electronicos.modelo.Modelo;
import com.TecnoNova.gestion_electronicos.repositorio.ModeloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ModeloServicio implements IModeloServicio{
    @Autowired
    private ModeloRepositorio modeloRepositorio;
    @Override
    public void guardarModelo(Modelo modelo) {
        modeloRepositorio.save(modelo);
    }

    @Override
    public void eliminarModelo(Modelo modelo) {
        modeloRepositorio.delete(modelo);
    }

    @Override
    public Modelo buscarModelo(int id) {
        return modeloRepositorio.findById(id).orElse(null);
    }

    @Override
    public List<Modelo> listaModelos() {
        return modeloRepositorio.findAll();
    }
}
