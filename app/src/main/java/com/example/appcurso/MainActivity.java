package com.example.appcurso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    private EditText etNombre, etApellido, etCedula, etUsuario, etContrasena, etContrasena2;
    private Button btnContinuar, btnQR;
    private TextView txtLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText) findViewById(R.id.etNombre);
        etApellido = (EditText) findViewById(R.id.etApellido);
        etCedula = (EditText) findViewById(R.id.etCedula);
        etUsuario = (EditText) findViewById(R.id.etUsuario);
        etContrasena = (EditText) findViewById(R.id.etContrasena);
        etContrasena2 = (EditText) findViewById(R.id.etContrasena2);
        btnContinuar = (Button) findViewById(R.id.btnContinuar);
        txtLogin = (TextView) findViewById(R.id.txtLogin);

        //prueba QR

        btnQR = (Button)findViewById(R.id.btnTestQR);

        btnQR.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, HomeEst.class);
                startActivity(i);
            }
        });

        btnContinuar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etNombre.getText().toString().isEmpty() && !etApellido.getText().toString().isEmpty() && !etCedula.getText().toString().isEmpty() && !etUsuario.getText().toString().isEmpty() && !etContrasena.getText().toString().isEmpty() && !etContrasena2.getText().toString().isEmpty()) {
                    if (etContrasena.getText().toString().equals(etContrasena2.getText().toString())) {
                        Intent i = new Intent(MainActivity.this, Registro.class);
                        i.putExtra("nombre", etNombre.getText().toString().trim().toUpperCase());
                        i.putExtra("apellido", etApellido.getText().toString().trim().toUpperCase());
                        i.putExtra("cedula", etCedula.getText().toString());
                        i.putExtra("usuario", etUsuario.getText().toString());
                        i.putExtra("contrasena", etContrasena.getText().toString());
                        startActivity(i);
                    } else {
                        Toast.makeText(MainActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    }
                } else {

                    Toast.makeText(MainActivity.this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
                    
                }
            }
        });

        txtLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });
    }
}