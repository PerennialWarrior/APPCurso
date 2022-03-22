package com.example.appcurso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.View.OnClickListener;

public class Login extends AppCompatActivity {

    private EditText etUsuario2, etContrasena3;
    private Button btnAcceder2;
    private TextView txtRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsuario2 = (EditText) findViewById(R.id.etUsuario2);
        etContrasena3 = (EditText) findViewById(R.id.etContrasena3);
        btnAcceder2 = (Button) findViewById(R.id.btnAcceder2);
        txtRegistro = (TextView) findViewById(R.id.txtRegistro);

        txtRegistro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}