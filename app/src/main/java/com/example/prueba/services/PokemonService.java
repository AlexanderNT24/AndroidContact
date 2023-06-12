package com.example.prueba.services;

import com.example.prueba.models.Publications;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PokemonService {

    @GET("pokemons")
    Call<List<Publications>> getAllUser();

    @GET("pokemons/{id}")
    Call<Publications> findUser(@Path("id") int id);

    @POST("pokemons")
    Call<Publications> create(@Body Publications pokemon);

    @PUT("pokemons/{id}")
    Call<Publications> update(@Path("id") int id, @Body Publications pokemon);

    @DELETE("pokemons/{id}")
    Call<Void> delete(@Path("id") int id);
}
