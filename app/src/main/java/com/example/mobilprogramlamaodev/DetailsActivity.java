package com.example.mobilprogramlamaodev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    private TextView sehirIsmi, sehirAciklama;
    private ImageView sehirResmi;
    private Intent getIntent;
    private String sAciklama;
    private String sIsim;
    private int sResim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        sehirIsmi = (TextView)findViewById(R.id.detailsisim);
        sehirAciklama = (TextView)findViewById(R.id.detailsaciklama);
        sehirResmi = (ImageView)findViewById(R.id.detailsresim);

        getIntent = getIntent();
        sIsim = getIntent.getStringExtra("sehirismi");
        sAciklama = getIntent.getStringExtra("sehiraciklama");
        sResim = getIntent.getIntExtra("sehirresmi", -1);
        if(!TextUtils.isEmpty(sIsim) && !TextUtils.isEmpty(sAciklama) && sResim != -1){

            sehirIsmi.setText(sIsim);
            sehirAciklama.setText(sAciklama);
            sehirResmi.setBackgroundResource(sResim);

        }

    }
}