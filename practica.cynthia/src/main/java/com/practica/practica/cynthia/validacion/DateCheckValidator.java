package com.practica.practica.cynthia.validacion;

import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class DateCheckValidator implements ConstraintValidator<DateCheck, Object> {

    private String fechaApertura;

    @Override
    public void initialize(DateCheck constraintAnnotation) {
        fechaApertura = constraintAnnotation.fechaApertura();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        LocalDateTime fechaAp = (LocalDateTime) PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(fechaApertura);

        return fechaAp.equals(LocalDateTime.now()) || fechaAp.isBefore(LocalDateTime.now());
    }
}
