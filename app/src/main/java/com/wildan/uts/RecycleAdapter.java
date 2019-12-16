package com.wildan.uts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecycleViewHolder> {
    public interface ItemClickListener {
        void onClick(View view, int position);
    }//tambahan
    private ArrayList<Anggrek> Anggrek;
    private ArrayList<Integer> gbrList;
    private Activity activity;
    private Context konteks;
    private ItemClickListener clickListener;
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);


    public RecycleAdapter( ArrayList<Anggrek> Anggrek,ArrayList<Integer> gbrList,Activity activity,Context konteks) {  //tambahan
        this.gbrList=gbrList; //tambahan
        this.konteks=konteks;
        this.Anggrek=Anggrek;
        this.activity=activity;
    }

    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new RecycleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        holder.txtjdl.setText(Anggrek.get(position).getJudul());
        holder.txthrg.setText(String.valueOf(formatRupiah.format(Anggrek.get(position).getHarga())));
        holder.imgGbr.setImageResource(gbrList.get(position)); //tambahan
    }

    @Override
    public int getItemCount() {
        return (gbrList != null) ? gbrList.size() : 0;
    }

    public void setClickListener(ItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public class RecycleViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView txtjdl, txthrg,txttotbyr;
        private ImageView imgGbr; //tambahan
        private LinearLayout view;
        public String KEY_JUDUL="judul";
        public String KEY_GAMBAR="gambar";
        public String KEY_HARGA="harga";

        public RecycleViewHolder(View itemView) {
            super(itemView);
            konteks = itemView.getContext();
            txtjdl = (TextView) itemView.findViewById(R.id.Judul);
            txthrg = (TextView) itemView.findViewById(R.id.Harga);
            txttotbyr = (TextView) itemView.findViewById(R.id.txttotbyr);
            imgGbr= itemView.findViewById(R.id.img_card); //tambahan
            view = itemView.findViewById(R.id.View);
            itemView.setTag(itemView);
            itemView.setOnClickListener(this);
            imgGbr.setOnClickListener(this);
            txtjdl.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        konteks = v.getContext();
                        Intent i = new Intent(konteks, DeskripsiActivity.class);
                        i.putExtra(KEY_JUDUL, Anggrek.get(position).getJudul());
                        i.putExtra(KEY_HARGA, Anggrek.get(position).getHarga());
                        i.putExtra(KEY_GAMBAR, gbrList.get(position));
                        konteks.startActivity(i);
                    }
                }
            });
        }
        public void onClick(View view) {
            if(clickListener != null) clickListener.onClick(view, getAdapterPosition());
        }
    }
}

