package com.example.prueba.services;

import com.example.prueba.models.Publication;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface PublicationService {

    @GET("publications")
    Call<List<Publication>> getAllPublications();

    @GET("publications/{id}")
    Call<Publication> findPublication(@Path("id") int id);

    @POST("publications")
    Call<Publication> createPublication(@Body Publication publication);

    @PUT("publications/{id}")
    Call<Publication> updatePublication(@Path("id") int id, @Body Publication publication);

    @DELETE("publications/{id}")
    Call<Void> deletePublication(@Path("id") int id);
}