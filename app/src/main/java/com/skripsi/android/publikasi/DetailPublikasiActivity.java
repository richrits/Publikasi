package com.skripsi.android.publikasi;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.File;

public class DetailPublikasiActivity extends AppCompatActivity {
    private static final String TAG = "DetailPublikasiActivity";
    public Boolean fileExist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_publikasi);
        Log.d(TAG, "onCreate: started");
        ActionBar actionBar = this.getSupportActionBar();

        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(R.string.title_detail);
        }

        getIncomingIntent();

        final Button download = findViewById(R.id.download);
        download.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                fileExist = fileExists(DetailPublikasiActivity.this,Environment.getExternalStorageState() + getIntent().getStringExtra("judul_publikasi")+".pdf");


                if (!fileExist){
                    Uri pdf_uri = Uri.parse("https://dl.dropboxusercontent.com/s/kewrxdh6aj7s1aj/publikasi1.pdf");
                    DownloadData(pdf_uri,v);
                }else{
                    Intent i = new Intent(DetailPublikasiActivity.this,PdfViewer.class);
                    startActivity(i);
                }
            }
        });

        final Button baca = findViewById(R.id.baca);
        baca.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(DetailPublikasiActivity.this, PdfViewer.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }

    private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: check incoming intent");

        if (getIntent().hasExtra("cover_publikasi") && getIntent().hasExtra("judul_publikasi")){
            Log.d(TAG, "getIncomingIntent: found intent extras");

            Bundle bundle=this.getIntent().getExtras();
            int coverPublikasi =  bundle.getInt("cover_publikasi");
            String judulPublikasi = getIntent().getStringExtra("judul_publikasi");
            String nomorKatalog = getIntent().getStringExtra("no_katalog");
            String nomorPublikasi = getIntent().getStringExtra("no_publikasi");
            String tanggalRilis = getIntent().getStringExtra("tanggal_rilis");
            String ukuranFile = getIntent().getStringExtra("ukuran_file");

            setDetail(coverPublikasi,judulPublikasi,nomorKatalog,nomorPublikasi,tanggalRilis,ukuranFile);


        }
    }

    private void setDetail(int coverPublikasi, String judulPublikasi, String nomorKatalog, String nomorPublikasi, String tanggalRilis, String ukuranFile){
        Log.d(TAG, "setDetail: setting detail");

        ImageView cover = findViewById(R.id.cover_publikasi);
        Glide.with(this)
                .asBitmap()
                .load(coverPublikasi)
                .into(cover);

        TextView judul = findViewById(R.id.judul_publikasi);
        judul.setText(judulPublikasi);

        TextView noKatalog = findViewById(R.id.nomor_katalog);
        noKatalog.setText(nomorKatalog);

        TextView noPublikasi = findViewById(R.id.nomor_publikasi);
        noPublikasi.setText(nomorPublikasi);

        TextView tglRilis = findViewById(R.id.tanggal_rilis);
        tglRilis.setText(tanggalRilis);

        TextView ukFile = findViewById(R.id.ukuran_publikasi);
        ukFile.setText(ukuranFile);



    }

    private long DownloadData (Uri uri, View v) {

        long downloadReference;

        // Create request for android download manager
        DownloadManager downloadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Request request = new DownloadManager.Request(uri);

        //Setting title of request
        request.setTitle("Data Download");

        //Setting description of request
        request.setDescription("Android Data download using DownloadManager.");

        //Set the local destination for the downloaded file to a path
        //within the application's external files directory
        request.setDestinationInExternalFilesDir(this,
        Environment.DIRECTORY_DOWNLOADS,getIntent().getStringExtra("judul_publikasi")+".pdf");

        //Enqueue download and save
        downloadReference = downloadManager.enqueue(request);


        return downloadReference;
    }


    public boolean fileExists(Context context, String filename) {
        File file = context.getFileStreamPath(filename);
        if(file == null || !file.exists()) {
            return false;
        }
        return true;
    }

}
