package es.jcyl.formacion.seguridadweb.weblogin.servicios;

import es.jcyl.formacion.seguridadweb.weblogin.datos.entidades.UsuarioDetalle;

import java.util.List;
import java.util.Optional;

public interface UsuarioDetalleServicio {

    void nuevoUsuarioDetalle (UsuarioDetalle userDetail);
    Optional<? extends UsuarioDetalle> obtenerUsuarioDetallePorId (Long userId);
    Optional<List<UsuarioDetalle>>listaUsuarioDetalle();
}


