package com.practica.practica.cynthia.error.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class ApiValidationSubError extends ApiSubError {

    private String objeto, campo, mensaje;
    private Object valorRechazado;


}