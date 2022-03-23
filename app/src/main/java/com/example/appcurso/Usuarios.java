package com.example.appcurso;

import org.json.JSONException;
import org.json.JSONObject;

public class Usuarios {

    String desactivar, cedula, nombre, apellido, facultad, cursos, programa, rol, usuario, contrasena;

    public Usuarios(JSONObject objetoJSON) throws JSONException {
        this.desactivar = objetoJSON.getString("desactivar");
        this.cedula = objetoJSON.getString("cedula");
        this.nombre = objetoJSON.getString("nombre");
        this.apellido = objetoJSON.getString("apellido");
        this.facultad = objetoJSON.getString("facultad");
        this.cursos = objetoJSON.getString("cursos");
        this.programa = objetoJSON.getString("programa");
        this.rol = objetoJSON.getString("rol");
        this.usuario = objetoJSON.getString("usuario");
        this.contrasena = objetoJSON.getString("contrasena");
    }

    public String getDesactivar() {
        return desactivar;
    }

    public void setDesactivar(String desactivar) {
        this.desactivar = desactivar;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public String getCursos() {
        return cursos;
    }

    public void setCursos(String cursos) {
        this.cursos = cursos;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
