package es.jcyl.formacion.seguridadweb.weblogin.validacion;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = UsuarioDetalleValidador.class)
public @interface UsuarioValidacion {

    String message() default "Datos del Usuario eno son válidos!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
