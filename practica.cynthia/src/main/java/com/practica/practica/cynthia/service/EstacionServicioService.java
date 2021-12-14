package com.practica.practica.cynthia.service;

import com.practica.practica.cynthia.dto.EstacionDto;
import com.practica.practica.cynthia.dto.EstacionDtoConverter;
import com.practica.practica.cynthia.error.excepciones.ListEntityNotFoundException;
import com.practica.practica.cynthia.error.excepciones.SingleEntityNotFoundException;
import com.practica.practica.cynthia.model.EstacionServicio;
import com.practica.practica.cynthia.repository.EstacionServicioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EstacionServicioService {

    private final EstacionServicioRepository estacionServicioRepository;
    private final EstacionDtoConverter estacionDtoConverter;

    public EstacionServicio findById(Long id) {
        return estacionServicioRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), EstacionServicio.class));
    }

    public List<EstacionServicio> findAll() {

        List<EstacionServicio> resultado = estacionServicioRepository.findAll();

        if (resultado.isEmpty()) {
            throw new ListEntityNotFoundException(EstacionServicio.class);
        } else
            return resultado;
    }

    public EstacionServicio save(EstacionServicio estacionServicio){
        return estacionServicioRepository.save(estacionServicio);
    }

    public void remove(Long id){

        estacionServicioRepository.findById(id)
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), EstacionServicio.class));

        if( estacionServicioRepository.findById(id)!=null){
            estacionServicioRepository.deleteById(id);
        }
    }

    public EstacionDto put(Long id, EstacionDto dto){
        return estacionServicioRepository.findById(id).map(e->{
            e.setFechaApertura(dto.getFechaApertura());
            e.setMaps(dto.getMaps());
            e.setMarca(dto.getMarca());
            e.setServicios(dto.getServicios());
            e.setPrecioGasoilEspecial(dto.getPrecioGasoilEspecial());
            e.setPrecioGasoilNormal(dto.getPrecioGasoilNormal());
            e.setPrecioGasolina95Octanos(dto.getPrecioGasolina95Octanos());
            e.setPrecioGasolina98(dto.getPrecioGasolina98());
            e.setNombre(dto.getNombre());
            estacionServicioRepository.save(e);
            return estacionDtoConverter.estacionServicioToEstacionDto(e);
        })
                .orElseThrow(() -> new SingleEntityNotFoundException(id.toString(), EstacionServicio.class));
    }
}