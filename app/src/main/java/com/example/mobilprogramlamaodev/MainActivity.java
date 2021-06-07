package com.example.mobilprogramlamaodev;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {


    private ListView mListView;
    private ArrayAdapter<String> adapter;
    private String[] sehirler = {"Rize","İstanbul","Ankara"};
    private String[] sehirlerAciklama = {"Rize, Karadeniz Bölgesi'nin Doğu Karadeniz bölümünde yer alan bir şehirdir. Tarihi Pontus bölgesinin doğusunda kalan Rize, Osmanlı döneminde Lazistan Sancağı'nda yer almıştır. Günümüzde Türkiye'ye bağlıdır.","İstanbul, Türkiye'de Marmara Bölgesi'nde yer alan şehir ve Türkiye Cumhuriyeti Devletinin 81 ilinden biridir. Ülkenin nüfus bakımından en çok göç alan ve en kalabalık ilidir. Ekonomik, tarihi ve sosyo-kültürel açıdan önde gelen şehirlerden biridir. Şehir, iktisadi büyüklük açısından dünyada 34. sırada yer alır.","Ankara, Türkiye'nin başkenti ve en kalabalık ikinci ilidir.[6] Nüfusu 2020 itibarıyla 5.663.322 kişidir. Bu nüfus; 25 ilçe ve bu ilçelere bağlı 1425 mahallede yaşamaktadır. İl genelinde nüfus yoğunluğu 215'tir. Nüfuslarına göre şehirler listesinde belediye sınırları göz önüne alınarak yapılan sıralamaya göre dünyada ise elli yedinci sırada yer almaktadır."};
    private int[] sehirlerResim = {R.drawable.rize,R.drawable.ankara,R.drawable.istanbul};
    private TextView sehirIsmi, sehirAciklama;
    private ImageView sehirResmi;
    private Intent detailsIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        //
        setContentView(R.layout.fragment_listeleme);
        mListView = (ListView)findViewById(R.id.ListemeleView);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sehirler);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                detailsIntent = new Intent(MainActivity.this, DetailsActivity.class);
                detailsIntent.putExtra("sehirismi", sehirler[position]);
                detailsIntent.putExtra("sehiraciklama", sehirlerAciklama[position]);
                detailsIntent.putExtra("sehirresmi", sehirlerResim[position]);
                startActivity(detailsIntent);

            }
        });


    }


    private void setSupportActionBar(Toolbar toolbar) {
    }
}