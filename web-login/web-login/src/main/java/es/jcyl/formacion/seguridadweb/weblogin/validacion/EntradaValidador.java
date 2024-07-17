package es.jcyl.formacion.seguridadweb.weblogin.validacion;

public interface EntradaValidador {

    void esUsuarioValido(String u);

    void esClaveValida (String p);

    void esUsuarioIdValido (String id);
}
