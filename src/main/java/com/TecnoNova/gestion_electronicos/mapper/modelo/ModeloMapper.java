package com.TecnoNova.gestion_electronicos.mapper.modelo;

import com.TecnoNova.gestion_electronicos.dto.modelo.ModeloDtoRequest;
import com.TecnoNova.gestion_electronicos.dto.modelo.ModeloDtoResponse;
import com.TecnoNova.gestion_electronicos.modelo.Modelo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModeloMapper {

    public ModeloDtoResponse entityToDtoResponse (Modelo modelo){
        return new ModeloDtoResponse(
                modelo.getIdModelo(),
                modelo.getNombreModelo()
        );
    }
    public Modelo DtoRequestToEntity (ModeloDtoRequest modeloDtoRequest){
        Modelo modelo = new Modelo();
        modelo.setNombreModelo(modeloDtoRequest.nombre());
        return modelo;
    }
    public List<ModeloDtoResponse> listEntityToDtoResponses (List<Modelo> modelos){
        return modelos.stream().map(this::entityToDtoResponse).toList();
    }
}
