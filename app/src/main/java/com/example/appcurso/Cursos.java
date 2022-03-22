package com.example.appcurso;

import org.json.JSONException;
import org.json.JSONObject;

public class Cursos {

    String nombre;

    public Cursos(JSONObject objetoJSON) throws JSONException {
        this.nombre = objetoJSON.getString("nombre");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String modelo) {
        this.nombre = nombre;
    }
}
