package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvMessage;
    private List<Integer> numbers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);

        Button btnMisPokemones = this.findViewById(R.id.buttonMisPokemones);

        Button btnAdd = this.findViewById(R.id.crearPokemon);


        btnMisPokemones.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ListaActivity.class);
            startActivity(intent);



        });
        btnAdd.setOnClickListener(view -> {


            Intent intent = new Intent(getApplicationContext(), CreateActivity.class);
            startActivity(intent);

        });

    }

}