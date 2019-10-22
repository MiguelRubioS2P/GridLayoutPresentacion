package com.example.gridlayoutpresentacion;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_activity);
    }


    public void verValor(View v){

        //Obtenemos el valor del edit text
        EditText campoText = (EditText) findViewById(R.id.teclado);
        TextView titulo = (TextView) findViewById(R.id.titulo);
        CalendarView calendario = (CalendarView) findViewById(R.id.calendario);

        String date = "29/8/1996";
        String parts[] = date.split("/");

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, (month - 1));
        calendar.set(Calendar.DAY_OF_MONTH, day);

        long milliTime = calendar.getTimeInMillis();

        if(campoText.getText().toString().equals("Miguel")){
            calendario.setDate( milliTime,true,true);
            campoText.setText("");
            //campoText.setText("");
        }

    }
}

