package com.TecnoNova.gestion_electronicos.servicios.modelo;

import com.TecnoNova.gestion_electronicos.dto.modelo.ModeloDtoRequest;
import com.TecnoNova.gestion_electronicos.dto.modelo.ModeloDtoResponse;
import com.TecnoNova.gestion_electronicos.modelo.Modelo;
import org.springframework.ui.Model;

import java.util.List;

public interface IModeloServicio {
    ModeloDtoResponse guardarModelo(ModeloDtoRequest dto);
    void eliminarModelo(Integer id);
    ModeloDtoResponse buscarModelo(Integer id);
    ModeloDtoResponse modificarModelo(Integer id, ModeloDtoRequest dtoRequest);
    List<ModeloDtoResponse> listaModelos();

}
