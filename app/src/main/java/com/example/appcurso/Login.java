package com.example.appcurso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.View.OnClickListener;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        btnAcceder2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!etUsuario2.getText().toString().equals("") && !etContrasena3.getText().toString().equals("")) {
                    new LoginAdministrador(Login.this).execute();
                } else {
                    Toast.makeText(Login.this, "Todos los campos son requeridos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private Administrador loginAdministrador() throws JSONException, IOException {

        String url = Constants.URL + "cursos/LoginAdministrador.php";

        List<NameValuePair> nameValuePairs;
        nameValuePairs = new ArrayList<NameValuePair>(1);
        nameValuePairs.add(new BasicNameValuePair("usuario", etUsuario2.getText().toString().trim()));

        String json = APIHandler.POSTRESPONSE(url, nameValuePairs);
        if (json != null) {
            JSONObject object = new JSONObject(json);
            JSONArray json_array = object.optJSONArray("administrador");
            if (json_array.length() > 0) {
                Administrador administrador = new Administrador(json_array.getJSONObject(0));
                return administrador;
            }
            return null;
        }
        return null;
    }

    class LoginAdministrador extends AsyncTask<String, String, String> {
        private Activity context;

        LoginAdministrador(Activity context) {
            this.context = context;
        }

        protected String doInBackground(String... params) {
            try {
                final Administrador administrador = loginAdministrador();
                if (administrador != null)
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Login.this, "Administrador", Toast.LENGTH_SHORT).show();
                        }
                    });
                else
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            new LoginUsuarios(Login.this).execute();
                        }
                    });
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private Usuarios loginUsuarios() throws JSONException, IOException {

        String url = Constants.URL + "cursos/LoginUsuarios.php";

        List<NameValuePair> nameValuePairs;
        nameValuePairs = new ArrayList<NameValuePair>(1);
        nameValuePairs.add(new BasicNameValuePair("usuario", etUsuario2.getText().toString().trim()));

        String json = APIHandler.POSTRESPONSE(url, nameValuePairs);
        if (json != null) {
            JSONObject object = new JSONObject(json);
            JSONArray json_array = object.optJSONArray("usuarios");
            if (json_array.length() > 0) {
                Usuarios usuarios = new Usuarios(json_array.getJSONObject(0));
                return usuarios;
            }
            return null;
        }
        return null;
    }

    class LoginUsuarios extends AsyncTask<String, String, String> {
        private Activity context;

        LoginUsuarios(Activity context) {
            this.context = context;
        }

        protected String doInBackground(String... params) {
            try {
                final Usuarios usuarios = loginUsuarios();
                if (usuarios != null)
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Login.this, "Usuario", Toast.LENGTH_SHORT).show();
                        }
                    });
                else
                    context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Login.this, "Usuario no registrado", Toast.LENGTH_SHORT).show();
                        }
                    });
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}