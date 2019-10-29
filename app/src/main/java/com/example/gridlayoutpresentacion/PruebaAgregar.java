package com.example.gridlayoutpresentacion;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PruebaAgregar extends AppCompatActivity {

    TextView titulo;
    Button agregar;
    EditText nombre;
    EditText fecha;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.prueba);

        titulo = (TextView) findViewById(R.id.tituloAgregar);
        agregar = findViewById(R.id.agregarPrueba);
        nombre = (EditText) findViewById(R.id.campoAPrueba);
        fecha = (EditText) findViewById(R.id.campoFPrueba);

    }

    //Actividades bloque

    public void volver(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }

    public void eliminar(View view){
        Intent i = new Intent(this,Prueba.class);
        startActivity(i);
        finish();
    }

    //----------------------------------------------------------------------------------------------

    public void crearFecha(View v){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String nombreC;
        String fechaC;

        nombreC = nombre.getText().toString();
        fechaC = fecha.getText().toString();

        if(nombreC.isEmpty() && fechaC.isEmpty()){
            nombre.setError("No se puso un nombre");
            fecha.setError("No se puso una fecha");
        }else if(nombreC.isEmpty()){
            nombre.setError("No se puso un nombre");
        }else if(fechaC.isEmpty()){
            fecha.setError("No se puso una fecha");
        }else{
            Toast.makeText(this,"Cumpleaños de " + nombreC, Toast.LENGTH_LONG).show();
            nombre.setText("");
            fecha.setText("");
            sp.edit().putString(nombreC,fechaC).apply();
        }
    }

    //Crear menú -----------------------------------------------------------------------------------

    @Override public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_agragar,menu);

        return true;

    }

    @Override public boolean onOptionsItemSelected(MenuItem opcionMenu){

        int id = opcionMenu.getItemId();



        if(id == R.id.inicioM){
            //llevar a la actividad de inicio
            volver(null);
            return true;
        }

        if(id == R.id.borrarM){
            //llevar a la actividad de borrar
            eliminar(null);
            return true;
        }

        return super.onOptionsItemSelected(opcionMenu);

    }

}
