package com.example.prueba;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;


import com.example.prueba.models.Publication;
import com.example.prueba.services.PublicationService;

import retrofit2.Call;


import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


import android.widget.TextView;


public class CreateActivity extends AppCompatActivity {

    private static final int OPEN_CAMERA_REQUEST = 1001;
    private static final int OPEN_GALLERY_REQUEST = 1002;
    private ImageView ivAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        int id = 1;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://647879cf362560649a2ddb9c.mockapi.io/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PublicationService service = retrofit.create(PublicationService.class);

        Button btnAdd = findViewById(R.id.btnAdd);
        EditText inputName = findViewById(R.id.inputDescription);
        EditText inputType = findViewById(R.id.inputDescription);

        btnAdd.setOnClickListener(view -> {
            String name = inputName.getText().toString();
            String type = inputType.getText().toString();
            String imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/full/00" + id + ".png";

            Publication newObject = new Publication();

            newObject.description=name;
            newObject.imageUrl=imageUrl;
            //newObject.coments=["(imageUrl)",];

            Call<Publication> createCall = service.createPublication(newObject);
            createCall.enqueue(new Callback<Publication>() {

                @Override
                public void onResponse(Call<Publication> call, retrofit2.Response<Publication> response) {
                    if (response.isSuccessful()) {
                        // Pokémon creado exitosamente
                        Publication created = response.body();
                        TextView textView=findViewById(R.id.textView);
                        textView.setText("ADD"+newObject);
                    } else {

                        // Manejar el código de error
                    }
                }

                @Override
                public void onFailure(Call<Publication> call, Throwable t) {
                    TextView textView=findViewById(R.id.textView);
                    textView.setText(t.toString());
                }
            });
        });

        ivAvatar = findViewById(R.id.ivAvatar);
        Button btnCamera = findViewById(R.id.btnOpenCamera);
        Button btnGallery = findViewById(R.id.btnGallery);

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleOpenCamera();
            }
        });

        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    openGallery();
                }
                else {
                    String[] permissions = new String[] {Manifest.permission.READ_EXTERNAL_STORAGE};
                    requestPermissions(permissions, 2000);
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 2000) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            } else {
                // Handle permission denied
            }
        }
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, OPEN_GALLERY_REQUEST);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == OPEN_CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            ivAvatar.setImageBitmap(photo);
        }

        if(requestCode == OPEN_GALLERY_REQUEST && resultCode == RESULT_OK) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close(); // close cursor

            Bitmap bitmap = BitmapFactory.decodeFile(picturePath);
            ivAvatar.setImageBitmap(bitmap);
        }

    }

    private void abrirCamara() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, OPEN_CAMERA_REQUEST);
    }



    private void handleOpenCamera() {
        if(checkSelfPermission(Manifest.permission.CAMERA)  == PackageManager.PERMISSION_GRANTED)
        {
            // abrir camara
            Log.i("MAIN_APP", "Tiene permisos para abrir la camara");
            abrirCamara();
        } else {
            // solicitar el permiso
            Log.i("MAIN_APP", "No tiene permisos para abrir la camara, solicitando");
            String[] permissions = new String[] {Manifest.permission.CAMERA};
            requestPermissions(permissions, 1000);
        }
    }
}