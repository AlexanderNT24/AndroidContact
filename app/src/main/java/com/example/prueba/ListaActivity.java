package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.prueba.adapters.NameAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        NameAdapter adapter = new NameAdapter(data(),dataphone());

        RecyclerView rvLista =  findViewById(R.id.rvListaSimple);
        rvLista.setLayoutManager(new LinearLayoutManager(this));
        rvLista.setAdapter(adapter);
    }


    private List<String> data() {
        List<String> names = new ArrayList<>();
        names.add("Luis");
        names.add("Marcos");
        names.add("Alonso");
        names.add("Lionel");
        names.add("Cristiano");
        names.add("Luis");
        names.add("Marcos");


        return names;

    }
    private List<String> dataphone() {
        List<String> names = new ArrayList<>();
        names.add("929928190");
        names.add("929928191");
        names.add("929928192");
        names.add("929928193");
        names.add("929928194");
        names.add("929928195");
        names.add("929928196");


        return names;

    }
}