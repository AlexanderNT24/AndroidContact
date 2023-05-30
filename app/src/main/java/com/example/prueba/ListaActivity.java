package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.prueba.adapters.AnimeAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        AnimeAdapter adapter = new AnimeAdapter(data());

        RecyclerView rvLista =  findViewById(R.id.rvListaSimple);
        rvLista.setLayoutManager(new LinearLayoutManager(this));
        rvLista.setAdapter(adapter);
    }


    private List<Anime> data() {
        //String titles, String descriptions, Boolean favorites, String imageurl
        List<Anime> items = new ArrayList<>();
        items.add(new Anime("One piece","Lore is a podcast about the frightening history behind common folklore. ... LORE. SOMETIMES THE TRUTH IS MORE FRIGHTENING THAN FICTION. About · Listen ...",true,"https://c-cl.cdn.smule.com/rs-s80/arr/b5/0a/8f387d33-086f-4ab5-9e3b-9643930ca151.jpg"));
        items.add(new Anime("One piece","Lore is a podcast about the frightening history behind common folklore. ... LORE. SOMETIMES THE TRUTH IS MORE FRIGHTENING THAN FICTION. About · Listen ...",true,"https://c-cl.cdn.smule.com/rs-s80/arr/b5/0a/8f387d33-086f-4ab5-9e3b-9643930ca151.jpg"));
        items.add(new Anime("One piece","Lore is a podcast about the frightening history behind common folklore. ... LORE. SOMETIMES THE TRUTH IS MORE FRIGHTENING THAN FICTION. About · Listen ...",true,"https://c-cl.cdn.smule.com/rs-s80/arr/b5/0a/8f387d33-086f-4ab5-9e3b-9643930ca151.jpg"));
        items.add(new Anime("One piece","Lore is a podcast about the frightening history behind common folklore. ... LORE. SOMETIMES THE TRUTH IS MORE FRIGHTENING THAN FICTION. About · Listen ...",true,"https://c-cl.cdn.smule.com/rs-s80/arr/b5/0a/8f387d33-086f-4ab5-9e3b-9643930ca151.jpg"));
        items.add(new Anime("One piece","Lore is a podcast about the frightening history behind common folklore. ... LORE. SOMETIMES THE TRUTH IS MORE FRIGHTENING THAN FICTION. About · Listen ...",true,"https://c-cl.cdn.smule.com/rs-s80/arr/b5/0a/8f387d33-086f-4ab5-9e3b-9643930ca151.jpg"));
        items.add(new Anime("One piece","Lore is a podcast about the frightening history behind common folklore. ... LORE. SOMETIMES THE TRUTH IS MORE FRIGHTENING THAN FICTION. About · Listen ...",true,"https://c-cl.cdn.smule.com/rs-s80/arr/b5/0a/8f387d33-086f-4ab5-9e3b-9643930ca151.jpg"));

        

        return items;

    }

}