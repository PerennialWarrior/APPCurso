package com.example.appcurso;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.StringTokenizer;

public class HomeEst extends AppCompatActivity implements View.OnClickListener {
    private TextView tvNombre,tvHora,tvFecha,tvLugar,tvIdScan;
    private Button btnScan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_est);

        tvNombre=(TextView) findViewById(R.id.tvEvento);
        tvHora=(TextView) findViewById(R.id.tvHoraEvento);
        tvFecha=(TextView) findViewById(R.id.tvFechaEvento);
        tvLugar=(TextView) findViewById(R.id.tvLugarEvento);
        tvIdScan=(TextView) findViewById(R.id.tvIdScan);

        btnScan=(Button) findViewById(R.id.btnScan);

        btnScan.setOnClickListener(this);


    }

    @SuppressLint("MissingSuperCall")
    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        //obtencion del escaneo
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,intent);
        if (scanningResult != null){
            //se obtuvo el resultado
            String scanContent=scanningResult.getContents();
            StringTokenizer t=new StringTokenizer(scanContent,"*");
            final String nombreEv=t.nextToken();
            final String horaEv=t.nextToken();
            final String fechaEv=t.nextToken();
            final String lugarEv=t.nextToken();

            tvNombre.setText(nombreEv);
            tvHora.setText(horaEv);
            tvFecha.setText(fechaEv);
            tvLugar.setText(lugarEv);
        }else{
            //no se obtuvo resultado
            Toast toast = Toast.makeText(getApplicationContext(),"No recibieron datos del escaneo",Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnScan){
            IntentIntegrator scanIntegrator=new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }
}