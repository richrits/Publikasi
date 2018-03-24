package com.skripsi.android.publikasi.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.skripsi.android.publikasi.DetailPublikasiActivity;
import com.skripsi.android.publikasi.Publikasi;
import com.skripsi.android.publikasi.R;

import java.util.List;

/**
 * Created by Harits on 3/18/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyView> {
    private static final String TAG = "RecyclerViewAdapter";

    private Context mContext;
    private List<Publikasi> list;
    public class MyView extends RecyclerView.ViewHolder {

        public TextView judulPublikasi;
        public ImageView coverPublikasi;
        public LinearLayout parentLayout;

        public MyView(View view) {
            super(view);
            Log.d(TAG, "MyView: started");
            judulPublikasi = (TextView) view.findViewById(R.id.judul_publikasi);
            coverPublikasi = (ImageView) view.findViewById(R.id.cover_publikasi);
            parentLayout = (LinearLayout) view.findViewById(R.id.parent_layout);


        }
    }

    public RecyclerViewAdapter(Context mContext, List<Publikasi> horizontalList) {
        this.mContext = mContext;
        this.list = horizontalList;
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: started");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.publikasi_item_row, parent, false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder, final int position) {
        Log.d(TAG, "onBindViewHolder: started");
        
        final Publikasi publikasi = list.get(position);

        holder.judulPublikasi.setText(publikasi.getJudul());

        Glide.with(mContext).load(publikasi.getCover()).into(holder.coverPublikasi);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on : " + publikasi.getJudul());
                Intent intent = new Intent(mContext, DetailPublikasiActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("cover_publikasi",publikasi.getCover());
                intent.putExtras(bundle); //masih statis
                intent.putExtra("judul_publikasi",publikasi.getJudul());
                intent.putExtra("no_katalog",publikasi.getNoKatalog());
                intent.putExtra("no_publikasi",publikasi.getNoPublikasi());
                intent.putExtra("tanggal_rilis",publikasi.getTanggalRilis());
                intent.putExtra("ukuran_file",publikasi.getUkuranFile());


                mContext.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
