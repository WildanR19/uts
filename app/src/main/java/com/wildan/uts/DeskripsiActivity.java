package com.wildan.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class DeskripsiActivity extends AppCompatActivity {

    private ImageView gambar;
    private TextView jdl,hrg;
    public String KEY_JUDUL="judul";
    public String KEY_GAMBAR="gambar";
    public String KEY_HARGA="harga";
    String Judul;
    double Harga;
    int gbr;
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deskripsi);
        gambar = findViewById(R.id.getGbr);
        jdl = findViewById(R.id.jdl);
        hrg = findViewById(R.id.hrg);


        Judul = getIntent().getStringExtra(KEY_JUDUL);
        Harga = getIntent().getDoubleExtra(KEY_HARGA, 0);
        gbr = getIntent().getIntExtra(KEY_GAMBAR, 0);

        gambar.setImageResource(gbr);
        jdl.setText(Judul);
        hrg.setText(String.valueOf(formatRupiah.format(Harga)));

    }

}
