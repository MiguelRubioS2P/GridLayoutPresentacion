package com.example.gridlayoutpresentacion;

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

import androidx.appcompat.app.AppCompatActivity;

public class Prueba extends AppCompatActivity {

    Button btnBorrar;
    EditText editCampoNombre;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBorrar = findViewById(R.id.borrarPrueba);
        editCampoNombre = (EditText) findViewById(R.id.campoPrueba);

    }

    //Actividades ----------------------------------------------------------------------------------
    public void volver(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }

    public void agregar(View view){
        Intent i = new Intent(this,PruebaAgregar.class);
        startActivity(i);
        finish();
    }
    // ---------------------------------------------------------------------------------------------

    public void eliminar(View view){
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        String nombre = editCampoNombre.getText().toString();

        sp.edit().remove(nombre).apply();
        
    }

    //Creación del menú ----------------------------------------------------------------------------
    @Override public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_prueba,menu);

        return true;

    }

    //Saber que actividad es la seleccionada.
    @Override public boolean onOptionsItemSelected(MenuItem opcionMenu){

        int id = opcionMenu.getItemId();

        if(id == R.id.inicioM){
            //llevar a la actividad de inicio
            volver(null);
            return true;
        }

        if(id == R.id.agregarM){
            //llevar a la actividad de agregar
            agregar(null);
            return true;
        }

        return super.onOptionsItemSelected(opcionMenu);

    }

}
