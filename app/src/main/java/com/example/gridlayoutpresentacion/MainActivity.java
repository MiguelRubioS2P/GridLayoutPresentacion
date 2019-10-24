package com.example.gridlayoutpresentacion;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    //Declaramos variables que usaremos en el MainActivity Version 1.4
    private CheckBox pro;
    private TextView titulo;
    private EditText campoFecha ;
    private Button pulsar;
    private Button crear ;
    private EditText campoText ;
    private CalendarView calendario;
    private SharedPreferences sp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_activity);

        //inicializamos variables.
        pro = (CheckBox) findViewById(R.id.pro);
        titulo = (TextView) findViewById(R.id.titulo);
        campoFecha = (EditText) findViewById(R.id.fecha);
        pulsar = findViewById(R.id.pulsar);
        crear = findViewById(R.id.crear);
        campoText = (EditText) findViewById(R.id.teclado);
        calendario = (CalendarView) findViewById(R.id.calendario);

        //Prueba datos
        String defaultShared = getPackageName() + "_preferences";
        sp = getSharedPreferences(defaultShared,MODE_PRIVATE);

    }

    // estado
    public void ir(View view){
        Intent i = new Intent(this,prueba.class);
        startActivity(i);
        finish();
    }

    //recibe un string fecha con formato 00/00/0000 y lo convierte en un tipo long Version 1.1
    public long cumpleFecha(String fecha){
        long cumple = 0;

        String date = fecha;
        String parts[] = date.split("/");

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, (month - 1));
        calendar.set(Calendar.DAY_OF_MONTH, day);

        cumple = calendar.getTimeInMillis();

        return cumple;
    }

    //Mostrar la fecha indicada junto un mensaje tipo Toast. Usamos setError. Version 1.3
    public void crearFecha(View v){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String nombre;
        String fecha;

        nombre = campoText.getText().toString();
        fecha = campoFecha.getText().toString();

        if(nombre.isEmpty() && fecha.isEmpty()){
            campoText.setError("No se puso un nombre");
            campoFecha.setError("No se puso una fecha");
        }else if(nombre.isEmpty()){
            campoFecha.setError("No se puso un nombre");
        }else if(fecha.isEmpty()){
            campoFecha.setError("No se puso una fecha");
        }else{
            calendario.setDate( cumpleFecha(fecha),true,true);
            Toast.makeText(this,"Cumpleaños de " + nombre, Toast.LENGTH_LONG).show();
            campoText.setText("");
            campoFecha.setText("");
            sp.edit().putString(nombre,fecha).apply();

            //para borrar hay que usar remove
        }

    }

    //controlar checkbox. Version 1.2
    public void activarModo(View v){

        if(pro.isChecked()){
            titulo.setText("Modo Pro");
            campoFecha.setVisibility(View.VISIBLE);
            crear.setVisibility(View.VISIBLE);
            pulsar.setEnabled(false);
            //pro.setVisibility(View.INVISIBLE);
            pro.setText("Buscar");
        }else{
            crear.setVisibility(View.INVISIBLE);
            campoFecha.setVisibility(View.INVISIBLE);
            pulsar.setEnabled(true);
            titulo.setText("Buscar");
            pro.setText("Modo pro?");
        }

    }

    //Modo simple, añadir un nombre y mostrar la fecha correspondiente. Version 1.0
    public void verValor(View v){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String campo = campoText.getText().toString();
        String prefStringFecha = sp.getString(campo,"");

        if(campoText.getText().toString().equals("Miguel") || campoText.getText().toString().equals("miguel")){
            calendario.setDate( cumpleFecha("29/8/1996"),true,true);
            campoText.setText("");
        }


        if(campoText.getText().toString().equals("Fran") || campoText.getText().toString().equals("fran")){
            calendario.setDate( cumpleFecha("2/7/1996"),true,true);
            campoText.setText("");
        }

        if(!prefStringFecha.isEmpty()){
            calendario.setDate(cumpleFecha(prefStringFecha),true,true);
            campoText.setText("");
        }
        
    }

    @Override public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_en_activity,menu);

        return true;

    }

    @Override public boolean onOptionsItemSelected(MenuItem opcionMenu){

        int id = opcionMenu.getItemId();

        if(id == R.id.borrar){
            //llevar a la actividad de borrar
            ir(null);
            return true;
        }

        if(id == R.id.agregar){
            //llevar a la actividad de borrar

            return true;
        }

        return super.onOptionsItemSelected(opcionMenu);

    }

}

