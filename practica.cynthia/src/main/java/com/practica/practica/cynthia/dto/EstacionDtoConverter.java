package com.practica.practica.cynthia.dto;

import com.practica.practica.cynthia.model.EstacionServicio;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EstacionDtoConverter {

    public EstacionServicio estacionDtoToEstacionServicio(EstacionDto dto){
        return EstacionServicio.builder()
                .id(dto.getId())
                .maps(dto.getMaps())
                .fechaApertura(dto.getFechaApertura())
                .precioGasoilEspecial(dto.getPrecioGasoilEspecial())
                .precioGasoilNormal(dto.getPrecioGasoilNormal())
                .precioGasolina95Octanos(dto.getPrecioGasolina95Octanos())
                .precioGasolina98(dto.getPrecioGasolina98())
                .servicios(dto.getServicios())
                .marca(dto.getMarca())
                .tieneAutolavado(dto.isTieneAutolavado())
                .nombre(dto.getNombre())
                .fechaRegistro(LocalDateTime.now())
                .fechaApertura(dto.getFechaApertura())
                .build();
    }

    public EstacionDto estacionServicioToEstacionDto(EstacionServicio estacionServicio){
        return EstacionDto.builder()
                .id(estacionServicio.getId())
                .maps(estacionServicio.getMaps())
                .fechaApertura(estacionServicio.getFechaApertura())
                .precioGasoilEspecial(estacionServicio.getPrecioGasoilEspecial())
                .precioGasoilNormal(estacionServicio.getPrecioGasoilNormal())
                .precioGasolina95Octanos(estacionServicio.getPrecioGasolina95Octanos())
                .precioGasolina98(estacionServicio.getPrecioGasolina98())
                .servicios(estacionServicio.getServicios())
                .marca(estacionServicio.getMarca())
                .tieneAutolavado(estacionServicio.isTieneAutolavado())
                .nombre(estacionServicio.getNombre())
                .build();
    }
}
