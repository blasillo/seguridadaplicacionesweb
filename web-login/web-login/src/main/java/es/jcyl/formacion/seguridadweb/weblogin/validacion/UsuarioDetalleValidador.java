package es.jcyl.formacion.seguridadweb.weblogin.validacion;

import es.jcyl.formacion.seguridadweb.weblogin.datos.entidades.UsuarioDetalle;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsuarioDetalleValidador implements ConstraintValidator<UsuarioValidacion, UsuarioDetalle> {

    private static final String WHITE_LIST_INPUT_REGEX = "^[a-zA-Z0-9_ ]{10,400}$";
    @Override
    public boolean isValid(UsuarioDetalle userDetail, ConstraintValidatorContext context) {

        boolean isValid = true;

        if (!userDetail.getDireccion().matches(WHITE_LIST_INPUT_REGEX)) {
            context.buildConstraintViolationWithTemplate("La dirección del usuario no es válida!")
                    .addConstraintViolation();
            isValid = false;
        }
        if (!userDetail.getTarjetaCredito().matches(WHITE_LIST_INPUT_REGEX)) {
            context.buildConstraintViolationWithTemplate("La tarjeta de crédito no es válida!")
                    .addConstraintViolation();
            isValid = false;
        }
        if (!userDetail.getComentario().matches(WHITE_LIST_INPUT_REGEX)) {
            context.buildConstraintViolationWithTemplate("Los comentarios del usuario no son válidos!")
                    .addConstraintViolation();
            isValid = false;
        }

        if (!isValid) {
            context.disableDefaultConstraintViolation();
        }

        return isValid;
    }
}
