package com.example.appcurso;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Registro extends AppCompatActivity {

    private Spinner spinnerFacultad, spinnerCursos, spinnerPrograma, spinnerRol;
    private Button btnAcceder;
    private String nombre, apellido, cedula, usuario, contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombre = getIntent().getStringExtra("nombre");
        apellido = getIntent().getStringExtra("apellido");
        cedula = getIntent().getStringExtra("cedula");
        usuario = getIntent().getStringExtra("usuario");
        contrasena = getIntent().getStringExtra("contrasena");

        spinnerFacultad = (Spinner) findViewById(R.id.spinnerFacultad);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.facultad, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFacultad.setAdapter(adapter);

        spinnerPrograma = (Spinner) findViewById(R.id.spinnerPrograma);
        spinnerCursos = (Spinner) findViewById(R.id.spinnerCursos);
        spinnerFacultad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (spinnerFacultad.getSelectedItem().toString().equals("Facultad de Ciencias Administrativas")) {
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(Registro.this, R.array.administrativas, android.R.layout.simple_spinner_item);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerPrograma.setAdapter(adapter2);

                    listarAdministrativas();
                } else if (spinnerFacultad.getSelectedItem().toString().equals("Facultad de Ciencias Básicas")) {
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(Registro.this, R.array.basicas, android.R.layout.simple_spinner_item);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerPrograma.setAdapter(adapter2);

                    listarBasicas();
                } else if (spinnerFacultad.getSelectedItem().toString().equals("Facultad de Comunicación y Ciencias Sociales")) {
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(Registro.this, R.array.sociales, android.R.layout.simple_spinner_item);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerPrograma.setAdapter(adapter2);

                    listarSociales();
                } else if (spinnerFacultad.getSelectedItem().toString().equals("Facultad de Humanidades y Artes")) {
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(Registro.this, R.array.artes, android.R.layout.simple_spinner_item);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerPrograma.setAdapter(adapter2);

                    listarArtes();
                } else {
                    ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(Registro.this, R.array.ingenieria, android.R.layout.simple_spinner_item);
                    adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerPrograma.setAdapter(adapter2);

                    listarIngenieria();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerRol = (Spinner) findViewById(R.id.spinnerRol);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(Registro.this, R.array.rol, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRol.setAdapter(adapter3);
        btnAcceder = (Button) findViewById(R.id.btnAcceder);

        btnAcceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Insertar(Registro.this).execute();
            }
        });

    }

    private boolean insertar() {

        String url = Constants.URL + "cursos/addUsuario.php";

        List<NameValuePair> nameValuePairs;
        nameValuePairs = new ArrayList<NameValuePair>(10);
        nameValuePairs.add(new BasicNameValuePair("desactivar", "1"));
        nameValuePairs.add(new BasicNameValuePair("cedula", cedula));
        nameValuePairs.add(new BasicNameValuePair("nombre", nombre));
        nameValuePairs.add(new BasicNameValuePair("apellido", apellido));
        nameValuePairs.add(new BasicNameValuePair("facultad", spinnerFacultad.getSelectedItem().toString()));
        nameValuePairs.add(new BasicNameValuePair("cursos", spinnerCursos.getSelectedItem().toString()));
        nameValuePairs.add(new BasicNameValuePair("programa", spinnerPrograma.getSelectedItem().toString()));
        nameValuePairs.add(new BasicNameValuePair("rol", spinnerRol.getSelectedItem().toString()));
        nameValuePairs.add(new BasicNameValuePair("usuario", usuario));
        nameValuePairs.add(new BasicNameValuePair("contrasena", contrasena));

        boolean response = APIHandler.POST(url, nameValuePairs);
        return response;
    }

    class Insertar extends AsyncTask<String, String, String> {
        private Activity context;

        Insertar(Activity context) {
            this.context = context;
        }

        protected String doInBackground(String... params) {
            if (insertar())
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "Usuario registrado", Toast.LENGTH_LONG).show();
                    }
                });
            else
                context.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, "Usuario no registrado", Toast.LENGTH_LONG).show();
                    }
                });
            return null;
        }
    }

    public void listarAdministrativas(){
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.URL + "cursos/getAdministrativas.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("cursos");
                            ArrayList<String> cursosAdministrativas = new ArrayList<>();
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                                String cursos = jsonObject1.getString("nombre");
                                cursosAdministrativas.add(cursos);
                            }
                            spinnerCursos.setAdapter(new ArrayAdapter<String>(Registro.this, android.R.layout.simple_spinner_dropdown_item, cursosAdministrativas));
                        }catch (JSONException e){e.printStackTrace();}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }

    public void listarBasicas(){
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.URL + "cursos/getBasicas.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("cursos");
                            ArrayList<String> cursosBasicas = new ArrayList<>();
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                                String cursos = jsonObject1.getString("nombre");
                                cursosBasicas.add(cursos);
                            }
                            spinnerCursos.setAdapter(new ArrayAdapter<String>(Registro.this, android.R.layout.simple_spinner_dropdown_item, cursosBasicas));
                        }catch (JSONException e){e.printStackTrace();}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }

    public void listarSociales(){
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.URL + "cursos/getSociales.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("cursos");
                            ArrayList<String> cursosSociales = new ArrayList<>();
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                                String cursos = jsonObject1.getString("nombre");
                                cursosSociales.add(cursos);
                            }
                            spinnerCursos.setAdapter(new ArrayAdapter<String>(Registro.this, android.R.layout.simple_spinner_dropdown_item, cursosSociales));
                        }catch (JSONException e){e.printStackTrace();}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }

    public void listarArtes(){
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.URL + "cursos/getArtes.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("cursos");
                            ArrayList<String> cursosArtes = new ArrayList<>();
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                                String cursos = jsonObject1.getString("nombre");
                                cursosArtes.add(cursos);
                            }
                            spinnerCursos.setAdapter(new ArrayAdapter<String>(Registro.this, android.R.layout.simple_spinner_dropdown_item, cursosArtes));
                        }catch (JSONException e){e.printStackTrace();}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }

    public void listarIngenieria(){
        RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
        StringRequest stringRequest=new StringRequest(Request.Method.POST, Constants.URL + "cursos/getIngenieria.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.getJSONArray("cursos");
                            ArrayList<String> cursosIngenieria = new ArrayList<>();
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject jsonObject1=jsonArray.getJSONObject(i);
                                String cursos = jsonObject1.getString("nombre");
                                cursosIngenieria.add(cursos);
                            }
                            spinnerCursos.setAdapter(new ArrayAdapter<String>(Registro.this, android.R.layout.simple_spinner_dropdown_item, cursosIngenieria));
                        }catch (JSONException e){e.printStackTrace();}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        int socketTimeout = 30000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(policy);
        requestQueue.add(stringRequest);
    }
}