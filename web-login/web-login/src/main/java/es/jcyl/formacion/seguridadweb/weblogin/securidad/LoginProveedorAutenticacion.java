package es.jcyl.formacion.seguridadweb.weblogin.securidad;

import es.jcyl.formacion.seguridadweb.weblogin.datos.entidades.Usuario;
import es.jcyl.formacion.seguridadweb.weblogin.datos.entidades.UsuarioDetalle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import es.jcyl.formacion.seguridadweb.weblogin.servicios.UsuarioDetalleServicio;
import es.jcyl.formacion.seguridadweb.weblogin.servicios.UsuarioServicio;
import es.jcyl.formacion.seguridadweb.weblogin.validacion.EntradaValidador;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Builder
@AllArgsConstructor
@Service
public class LoginProveedorAutenticacion implements AuthenticationProvider {

    private final UsuarioServicio userService;
    private final UsuarioDetalleServicio userDetailsService;
    private final EntradaValidador inputValidator;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        inputValidator.esUsuarioValido (username);
        inputValidator.esClaveValida (password);

        Optional<Usuario> user = userService.encontrarUsuarioPorNombreClave (username, password);

        if (user.isEmpty()) {
            throw new BadCredentialsException("Nombre de suaurio o contraseña incorrectos!");
        }

        UsuarioLogin usuarioDetalle = (UsuarioLogin) userDetailsService.obtenerUsuarioDetallePorId( user.get().getId()).get();
        return new UsernamePasswordAuthenticationToken(usuarioDetalle, password, usuarioDetalle.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
