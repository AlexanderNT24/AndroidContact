package com.example.prueba.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.prueba.R;
import com.example.prueba.models.Publication;
import com.example.prueba.models.Publications;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PublicationAdapter extends RecyclerView.Adapter<PublicationAdapter.NameViewHolder> {

    private List<Publication> items;


    public PublicationAdapter(List<Publication> items) {
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
        Publication item = items.get(position);

        View view = holder.itemView;

        Log.i("PASA","OK");
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvDescription = view.findViewById(R.id.tvDescription);
        ImageView imgFav = view.findViewById(R.id.imgFav);

        ImageView imageView = view.findViewById(R.id.imageView);


        tvTitle.setText(item.description);


        Picasso.get().load(item.imageUrl).into(imageView);






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
