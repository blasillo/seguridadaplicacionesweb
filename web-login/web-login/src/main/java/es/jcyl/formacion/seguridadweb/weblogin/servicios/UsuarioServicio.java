package es.jcyl.formacion.seguridadweb.weblogin.servicios;

import es.jcyl.formacion.seguridadweb.weblogin.datos.entidades.Usuario;

import java.util.Optional;

public interface UsuarioServicio {


    Optional<Usuario> encontrarUsuarioPorNombreClave (String username, String password);

    Optional<Usuario> getUsuarioInfo(String userId);

    default Optional<Usuario> obtenerUsuarioInfoPorNombre (String username) {
        return Optional.empty();
    }

}
