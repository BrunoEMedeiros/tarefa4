package com.example.atividademap;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.media.MediaRecorder.VideoSource.CAMERA;

public class CameraActivity extends AppCompatActivity {

    private ImageView imgCamera;
    private Button btnFoto;
    private TextView txtQuantidade;

    private SharedPreferences sharedPreferences = null;
    private SharedPreferences.Editor editor = null;

    private String local;
    private int quantidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imgCamera = (ImageView) findViewById(R.id.imgCamera);
        btnFoto = (Button) findViewById(R.id.btnFoto);
        txtQuantidade = (TextView) findViewById(R.id.txtQuantidade);

        sharedPreferences = getSharedPreferences("PHOTO", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(getIntent().getExtras() != null){
            local = getIntent().getExtras().getString("local");
            quantidade = sharedPreferences.getInt(local,0);
            txtQuantidade.setText(String.valueOf(quantidade));
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(CameraActivity.this,MapsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (Intent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(Intent, CAMERA);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            switch (requestCode){
                case CAMERA:
                    Bundle extras = data.getExtras();
                    Bitmap imageBitmap = (Bitmap) extras.get("data");
                    imgCamera.setImageBitmap(imageBitmap);

                    int quantidade = sharedPreferences.getInt(local,0);
                    editor.putInt(local,++quantidade);
                    editor.apply();
                    txtQuantidade.setText(String.valueOf(quantidade));
            }

        }
    }
}