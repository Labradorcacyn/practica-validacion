package com.practica.practica.cynthia.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class EstacionServicio implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String marca;

    private String maps;

    private boolean tieneAutolavado = false;

    private double precioGasoilNormal;

    private double precioGasolina95Octanos;

    private double precioGasoilEspecial;

    private double precioGasolina98;

    @Lob
    private String servicios;

    @Past
    private LocalDateTime fechaApertura;

    private LocalDateTime fechaRegistro = LocalDateTime.now();

}