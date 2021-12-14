package com.practica.practica.cynthia.controller;

import com.practica.practica.cynthia.dto.EstacionDto;
import com.practica.practica.cynthia.dto.EstacionDtoConverter;
import com.practica.practica.cynthia.model.EstacionServicio;
import com.practica.practica.cynthia.service.EstacionServicioService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/estacion")
public class EstacionServicioController {

    private final EstacionServicioService estacionServicioService;
    private final EstacionDtoConverter estacionDtoConverter;

    @GetMapping("/")
    public List<EstacionServicio> getAll(){
        return estacionServicioService.findAll();
    }

    @GetMapping("/{id}")
    public EstacionServicio getById(@PathVariable @Min(value = 0, message = "No se pueden buscar productos con un identificador negativo") Long id){

        return estacionServicioService.findById(id);
    }

    @PostMapping("/")
    public EstacionDto crear(@Valid @RequestBody EstacionDto dto){
       estacionServicioService.save(estacionDtoConverter.estacionDtoToEstacionServicio(dto));
       return dto;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
            estacionServicioService.remove(id);
    }

    @PutMapping("/{id}")
    public EstacionDto putEstacion(@PathVariable Long id,@Valid @RequestBody EstacionDto dto){
       return estacionServicioService.put(id, dto);
    }
}