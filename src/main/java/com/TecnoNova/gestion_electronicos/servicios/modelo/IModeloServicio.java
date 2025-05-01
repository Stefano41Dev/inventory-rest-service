package com.TecnoNova.gestion_electronicos.servicios.modelo;

import com.TecnoNova.gestion_electronicos.modelo.Modelo;

import java.util.List;

public interface IModeloServicio {
    public void guardarModelo(Modelo modelo);
    public void eliminarModelo(Modelo modelo);
    public Modelo buscarModelo(int id);
    public List<Modelo> listaModelos();
}
