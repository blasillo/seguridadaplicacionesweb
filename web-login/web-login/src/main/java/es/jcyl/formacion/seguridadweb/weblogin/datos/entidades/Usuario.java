package es.jcyl.formacion.seguridadweb.weblogin.datos.entidades;

public interface Usuario {

    Long getId();
    void setId (Long id);

    String getNombreUsuario();
    void setNombreUsuario(String nu);

    String getClave();
    void setClave(String p);

    String getNombre();
    void setNombre(String n);

    String getApellidos();
    void setApellidos(String a);

}
