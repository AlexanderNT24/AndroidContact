package com.example.prueba.adapters;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.prueba.ListaActivity;
import com.example.prueba.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {

    private List<String> itemsName;
    private List<String> itemsPhoneNumber;

    public NameAdapter(List<String> items,List<String> itemsPhoneNumber) {
        this.itemsName = items;
        this.itemsPhoneNumber = itemsPhoneNumber;

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
        String item = itemsName.get(position);
        String itemPhoneNumber = itemsPhoneNumber.get(position);
        View view = holder.itemView;

        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvPhoneNumber = view.findViewById(R.id.tvPhoneNumber);
        ImageView imageView = view.findViewById(R.id.imageView);


        tvName.setText(item);
        tvPhoneNumber.setText(itemPhoneNumber);

        Button btnCall = view.findViewById(R.id.btnCall);

        Button btnMessage = view.findViewById(R.id.btnMessage);




        btnCall.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View views) {

                Context context = views.getContext();
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:1234567890"));
                context.startActivity(callIntent);

            }

        });

        btnMessage.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View views) {
                Context context = views.getContext();
                String mobileNumber = tvPhoneNumber.getText().toString();
                String messageText = "Hola amigo".toString();

                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(mobileNumber, null, messageText, null, null);

                Toast.makeText(context, "Message sent successfully!", Toast.LENGTH_SHORT).show();




            }

        });


        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(imageView);

    }
public void ventana(){
        /*
    AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
    builder.setTitle("My Dialog");
    builder.setMessage("This is a Dialog message.");
    builder.setPositiveButton("OK", null);

    AlertDialog dialog = builder.create();
    dialog.show();*/
}

    @Override
    public int getItemCount() {
        return itemsName.size();
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {

        public NameViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
