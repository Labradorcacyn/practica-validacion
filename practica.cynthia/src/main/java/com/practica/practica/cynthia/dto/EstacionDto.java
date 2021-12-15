package com.practica.practica.cynthia.dto;

import com.practica.practica.cynthia.validacion.DateCheck;
import com.practica.practica.cynthia.validacion.LocatedCheck;
import lombok.*;

import javax.persistence.Lob;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@NoArgsConstructor @AllArgsConstructor
@Builder
@Getter @Setter
@DateCheck(fechaApertura = "fechaApertura", fechaRegistro = "fechaRegistro",message = "{estacionServicio.fecha.validate}")
public class EstacionDto {
    private Long id;

    @NotBlank(message = "{estacionServicio.nombre.blank}")
    private String nombre;

    private String marca;

   @Pattern(
            regexp = "^(\\-?\\d+(\\.\\d+)?),\\w*(\\-?\\d+(\\.\\d+)?)$",
            message = "{estacionServicio.maps.validate}"
    )

   @LocatedCheck(maps = "maps", message = "{estacionServicio.mapsEqual.validate}")
    private String maps;

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