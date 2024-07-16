package es.jcyl.formacion.seguridadweb.weblogin.datos.entidades;
import java.util.UUID;


public interface UsuarioDetalle {
    UUID getId();
    void setId(UUID id);

    Long getUsuarioId();
    void setUsuarioId(Long userId);

    String getDireccion();
    void setDireccion(String dir);

    String getTarjetaCredito();
    void setTarjetaCredito(String cc);

    String getComentario();
    void setComentario(String c);
}
