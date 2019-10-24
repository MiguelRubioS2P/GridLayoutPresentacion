package com.example.gridlayoutpresentacion;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class prueba extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void volver(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }


    @Override public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_prueba,menu);

        return true;

    }

    @Override public boolean onOptionsItemSelected(MenuItem opcionMenu){

        int id = opcionMenu.getItemId();

        if(id == R.id.inicio){
            //llevar a la actividad de borrar
            volver(null);
            return true;
        }

        if(id == R.id.agregar){
            //llevar a la actividad de borrar

            return true;
        }

        return super.onOptionsItemSelected(opcionMenu);

    }

}
