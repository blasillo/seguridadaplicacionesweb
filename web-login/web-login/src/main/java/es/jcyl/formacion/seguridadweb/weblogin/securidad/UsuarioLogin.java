package es.jcyl.formacion.seguridadweb.weblogin.securidad;

import lombok.Getter;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Builder
@Getter
public class UsuarioLogin implements UserDetails {

    private Long usuarioId;
    private String nombreUsuario;
    private String clave;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public String getPassword() {
        return getClave();
    }

    @Override
    public String getUsername() {
        return getNombreUsuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
