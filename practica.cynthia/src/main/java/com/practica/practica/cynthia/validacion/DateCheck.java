package com.practica.practica.cynthia.validacion;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = DateCheckValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DateCheck {
    String message() default "{estacionServicio.fecha.validate}";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

    String fechaApertura();
    String fechaRegistro();

}
