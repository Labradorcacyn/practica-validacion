package com.practica.practica.cynthia.validacion;

import com.practica.practica.cynthia.repository.EstacionServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LocatedCheckValidator implements ConstraintValidator<LocatedCheck, String> {

    private String maps;

    @Autowired
    private EstacionServicioRepository estacionServicioRepository;

    @Override
    public void initialize(LocatedCheck constraintAnnotation) {maps = constraintAnnotation.maps();}

    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {
        return StringUtils.hasText(o) && !estacionServicioRepository.existsByMaps(o);
    }
}
