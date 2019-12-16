package com.wildan.uts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements RecycleAdapter.ItemClickListener {

    private RecycleAdapter rAdapter;
    private ArrayList<Integer> gambarbrg;
    private ArrayList<Anggrek> Anggrek;
    private int gbr[] = {R.drawable.anggrek1, R.drawable.anggrek2, R.drawable.anggrek3, R.drawable.anggrek4,R.drawable.anggrek5,R.drawable.anggrek6};
    private ImageView gambar;
    private float tot, bayar;
    private TextView totbyr;
    public String KEY_BAYAR="bayar";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totbyr = (TextView) findViewById(R.id.txttotbyr);
        RecyclerView rView = (RecyclerView) findViewById(R.id.my_recycler_view);
        rView.setHasFixedSize(true);
        GridLayoutManager k = new GridLayoutManager(this, 2);
        rView.setLayoutManager(k);
        gambarbrg = new ArrayList<>();
        ambdata();
        item();
        rAdapter = new RecycleAdapter(Anggrek,gambarbrg,this,this);
        rView.setAdapter(rAdapter);
        rAdapter.setClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void sms() {
        Uri sms_uri = Uri.parse("smsto:+6281244556677");
        Intent sms = new Intent(Intent.ACTION_SENDTO, sms_uri);
        sms.putExtra("SMS", "SMS center");
        startActivity(sms);
    }

    public void call() {
        Uri call_uri = Uri.parse("tel: +6281244556677");
        Intent call = new Intent(Intent.ACTION_DIAL, call_uri);
        call.putExtra("Call", "Call center");
        startActivity(call);
    }

    public void Lokasi() {
        String loc = "Kampung Anggrek Sodong Semarang";
        Uri addressUri = Uri.parse("geo:-7.079684,110.3273094?q=" + loc);
        Intent map = new Intent(Intent.ACTION_VIEW, addressUri);
        startActivity(map);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.call) {
            call();
        }
        if (id == R.id.sms) {
            sms();
        }
        if (id == R.id.map) {
            Lokasi();
        }


        return super.onOptionsItemSelected(item);
    }

    public void ambdata() {
        Anggrek = new ArrayList<>();
        Anggrek.add(new Anggrek("Anggrek Bulan",100000));
        Anggrek.add(new Anggrek("Anggrek Vanda",600000));
        Anggrek.add(new Anggrek("Anggrek Putih",400000));
        Anggrek.add(new Anggrek("Anggrek Ungu",400000));
        Anggrek.add(new Anggrek("Anggrek Dendrobium Secund", 650000));
        Anggrek.add(new Anggrek("Anggrek Candy Strip", 250000));
    }
    public void item(){
        for (int w=0; w<gbr.length; w++){
            gambarbrg.add(gbr[w]);
        }
    }

    @SuppressLint("ResourceType")
    public void onClick(View view, int position) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        if(gambarbrg.get(position) == gbr[0]){
            bayar = 100000;
            tot=tot+bayar;
            totbyr.setText(formatRupiah.format(tot));
        }
        if(gambarbrg.get(position) == gbr[1]){
            bayar = 600000;
            tot=tot+bayar;
            totbyr.setText(formatRupiah.format(tot));
        }
        if(gambarbrg.get(position) == gbr[2]){
            bayar = 400000;
            tot=tot+bayar;
            totbyr.setText(String.valueOf(formatRupiah.format(tot)));
        }
        if(gambarbrg.get(position) == gbr[3]){
            bayar = 400000;
            tot=tot+bayar;
            totbyr.setText(String.valueOf(formatRupiah.format(tot)));
        }
        if(gambarbrg.get(position) == gbr[4]){
            bayar = 650000;
            tot=tot+bayar;
            totbyr.setText(String.valueOf(formatRupiah.format(tot)));
        }
        if(gambarbrg.get(position) == gbr[5]){
            bayar = 250000;
            tot=tot+bayar;
            totbyr.setText(String.valueOf(formatRupiah.format(tot)));
        }
    }

    public void totbyar(View view) {
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        Intent i = new Intent(getApplicationContext(), BayarActivity.class);
        i.putExtra(KEY_BAYAR, tot);
        startActivity(i);
    }
}

