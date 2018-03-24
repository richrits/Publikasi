package com.skripsi.android.publikasi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

/**
 * Created by Harits on 3/19/2018.
 */

public class PdfViewer extends AppCompatActivity {
    private static final String TAG = "PdfViewer";

    PDFView pdfView;
    boolean fileExist;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        Log.d(TAG, "onCreate: start");
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_pdf_view);

         fileExist = fileExists(PdfViewer.this,Environment.getExternalStorageDirectory()
                + File.separator+getIntent().getStringExtra("judul_publikasi")+".pdf");

        if (fileExist==true){
            Log.d(TAG, "onCreate: buka pdf");
            //pdfView = (PDFView) findViewById(R.id.pdfViewer);
            //File file = new File(Environment.getExternalStorageState() + "publikasi 1.pdf");
            //pdfView.fromAsset().load();
        }else{
            Log.d(TAG, "onCreate: pdf tidak ada");
           // Toast.makeText(PdfViewer.this,"Data belum didownload",Toast.LENGTH_LONG).show();
        }
    }


    public boolean fileExists(Context context, String filename) {
        File file = context.getFileStreamPath(filename);
        if(file == null || !file.exists()) {
            return false;
        }
        return true;
    }
}