package com.TecnoNova.gestion_electronicos.servicios.modelo;

import com.TecnoNova.gestion_electronicos.dto.modelo.ModeloDtoRequest;
import com.TecnoNova.gestion_electronicos.dto.modelo.ModeloDtoResponse;
import com.TecnoNova.gestion_electronicos.mapper.modelo.ModeloMapper;
import com.TecnoNova.gestion_electronicos.modelo.Modelo;
import com.TecnoNova.gestion_electronicos.repositorio.ModeloRepositorio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ModeloServicio implements IModeloServicio{
    private final ModeloMapper modeloMapper;
    private final ModeloRepositorio modeloRepositorio;
    @Override
    public ModeloDtoResponse guardarModelo(ModeloDtoRequest dto) {
        Modelo modelo = modeloMapper.DtoRequestToEntity(dto);
        return modeloMapper.entityToDtoResponse(modeloRepositorio.save(modelo));
    }

    @Override
    public void eliminarModelo(Integer id) {
        if(modeloRepositorio.existsById(id)){
            modeloRepositorio.deleteById(id);
        }
    }

    @Override
    public ModeloDtoResponse buscarModelo(Integer id) {
        Modelo modelo = modeloRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Modelo no encontrado"));
        return modeloMapper.entityToDtoResponse(modelo);
    }
    @Override
    public ModeloDtoResponse modificarModelo(Integer id,  ModeloDtoRequest dtoRequest) {
        Modelo modelo = modeloRepositorio.findById(id)
                .orElseThrow(()-> new RuntimeException("Modelo no encontrado"));
        modelo.setNombreModelo(modelo.getNombreModelo());
        modeloRepositorio.save(modelo);
        return modeloMapper.entityToDtoResponse(modelo);
    }

    @Override
    public List<ModeloDtoResponse> listaModelos() {
        return modeloRepositorio.findAll().stream().map(modeloMapper::entityToDtoResponse).toList();
    }
}
