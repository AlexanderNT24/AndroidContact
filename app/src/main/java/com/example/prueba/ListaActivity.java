package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.prueba.adapters.PokemonAdapter;
import com.example.prueba.adapters.PublicationAdapter;
import com.example.prueba.models.Publication;
import com.example.prueba.models.Publications;
import com.example.prueba.services.PokemonService;
import com.example.prueba.services.PublicationService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        RecyclerView rvLista = findViewById(R.id.rvListaSimple);
        rvLista.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://647879cf362560649a2ddb9c.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PublicationService service = retrofit.create(PublicationService.class);

        Call<List<Publication>> call = service.getAllPublications();
        call.enqueue(new Callback<List<Publication>>() {
            @Override
            public void onResponse(Call<List<Publication>> call, Response<List<Publication>> response) {
                if (response.isSuccessful()) {
                    List<Publication> responseP = response.body();
                    PublicationAdapter adapter = new PublicationAdapter(responseP);
                    rvLista.setAdapter(adapter);
                } else {
                    // Error al obtener la lista de usuarios
                    // Manejar el código de error
                }
            }

            @Override
            public void onFailure(Call<List<Publication>> call, Throwable t) {
                // Error en la solicitud
                // Manejar el error
            }
        });
    }

}
