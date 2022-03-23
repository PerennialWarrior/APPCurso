package com.example.appcurso;

import org.json.JSONException;
import org.json.JSONObject;

public class Administrador {

    String usuario, contrasena;

    public Administrador(JSONObject objetoJSON) throws JSONException {
        this.usuario = objetoJSON.getString("usuario");
        this.contrasena = objetoJSON.getString("contrasena");
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
