package com.wildan.uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.text.NumberFormat;
import java.util.Locale;

public class BayarActivity extends AppCompatActivity {
    public String KEY_BAYAR="bayar";
    private EditText trans,bayar,kembali;
    float tra;
    private float byr,kemb;
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bayar);

        trans = (EditText) findViewById(R.id.txtTransaksi);
        bayar = (EditText) findViewById(R.id.txtJmlByr);
        kembali = (EditText) findViewById(R.id.txtKembali);

        tra = getIntent().getFloatExtra(KEY_BAYAR, 0);

        trans.setText(String.valueOf(formatRupiah.format(tra)));

        bayar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(bayar.getText().toString().isEmpty()){
                    byr=0;
                }else {
                    byr = Float.parseFloat(bayar.getText().toString());
                }
                kemb= byr-tra;
                kembali.setText(formatRupiah.format(kemb));

            }
        });


    }
}

