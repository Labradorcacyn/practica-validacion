package com.practica.practica.cynthia.dto;

import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter @Setter
public class EstacionDto {
    private Long id;

    @NotBlank(message = "{EstacionServicio.nombre.blank}")
    private String nombre;

    private String marca, maps;

    private boolean tieneAutolavado = false;

    @Lob
    private String servicios;

    @PositiveOrZero(message = "{estacionServicio.precio.min}")
    @NotNull(message = "{estacionServicio.precio.null}")
    private double precioGasoilNormal, precioGasolina95Octanos;

    @PositiveOrZero(message = "{estacionServicio.precio.min}")
    private double precioGasoilEspecial, precioGasolina98;

    @Past
    private LocalDateTime fechaApertura;
}
