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

    @NotBlank(message = "{EstacionServicio.nombre.blank}")
    private String nombre;

    private String marca;

    private String maps;

    private boolean tieneAutolavado = false;

    @Min(value = 0, message = "{estacionServicio.precio.min}")
    @NotNull(message = "{estacionServicio.precio.null}")
    private double precioGasoilNormal;

    @Min(value = 0, message = "{estacionServicio.precio.min}")
    @NotNull(message = "{estacionServicio.precio.null}")
    private double precioGasolina95Octanos;

    @Min(value = 0, message = "{estacionServicio.precio.min}")
    private double precioGasoilEspecial;

    @Min(value = 0, message = "{estacionServicio.precio.min}")
    private double precioGasolina98;

    @Lob
    private String servicios;

    @Past
    private LocalDateTime fechaApertura;

}