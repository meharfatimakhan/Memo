package com.example.fyp_work;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView img;
    Button btn;
    private static final int PICK_IMAGE=100;
    Uri imageUir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        img=(ImageView)findViewById(R.id.image_upload);
        btn=(Button)findViewById(R.id.button_upload);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }
    private void openGallery()
    {
        Intent gallery=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);
    }
    @Override
    protected void onActivityResult(int requestcode,int resultcode, Intent data)
    {
        super.onActivityResult(requestcode,resultcode,data);
        if(resultcode==RESULT_OK &&  requestcode==PICK_IMAGE)
        {
            imageUir=data.getData();
            img.setImageURI(imageUir);
        }
    }
}
