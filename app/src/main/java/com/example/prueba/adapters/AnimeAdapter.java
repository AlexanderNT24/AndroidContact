package com.example.prueba.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.prueba.Anime;
import com.example.prueba.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.NameViewHolder> {

    private List<Anime> items;


    public AnimeAdapter(List<Anime> items) {
        this.items = items;
    }


    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_string, parent, false);
        NameViewHolder viewHolder = new NameViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
        Anime item = items.get(position);

        View view = holder.itemView;

        Log.i("PASA","OK");
        TextView tvTitle = view.findViewById(R.id.tvTitle);
       TextView tvDescription = view.findViewById(R.id.tvDescription);
       ImageView imgFav = view.findViewById(R.id.imgFav);

        ImageView imageView = view.findViewById(R.id.imageView);


        tvTitle.setText(item.getTitles());
        tvDescription.setText(item.getDescriptions());

        Picasso.get().load(item.getImageurl()).into(imageView);






    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
