package com.skripsi.android.publikasi.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.skripsi.android.publikasi.Publikasi;
import com.skripsi.android.publikasi.R;

import java.util.List;

/**
 * Created by Harits on 3/18/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyView> {
    private Context mContext;
    private List<Publikasi> list;
    public class MyView extends RecyclerView.ViewHolder {

        public TextView judulPublikasi;
        public ImageView coverPublikasi;

        public MyView(View view) {
            super(view);

            judulPublikasi = (TextView) view.findViewById(R.id.judul_publikasi);
            coverPublikasi = (ImageView) view.findViewById(R.id.cover_publikasi);


        }
    }

    public RecyclerViewAdapter(Context mContext, List<Publikasi> horizontalList) {
        this.mContext = mContext;
        this.list = horizontalList;
    }

    @Override
    public MyView onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.publikasi_item_row, parent, false);

        return new MyView(itemView);
    }

    @Override
    public void onBindViewHolder(final MyView holder, final int position) {
        Publikasi publikasi = list.get(position);

        holder.judulPublikasi.setText(publikasi.getJudul());

        Glide.with(mContext).load(publikasi.getCover()).into(holder.coverPublikasi);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
