package com.example.mypegasus.readwritedata;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    private static final String ASSETS_TAG = "AssetsData";
    private static final String RAW_TAG = "RawData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        findViewById(R.id.btn_readAssetsTxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream is = getResources().getAssets().open("info.txt");
                    InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                    BufferedReader bfr = new BufferedReader(isr);
//                    Log.i(ASSETS_TAG, bfr.readLine());
                    String in = "";
                    while ((in = bfr.readLine()) != null) {
                        Log.i(ASSETS_TAG, in);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        findViewById(R.id.btn_readRawTxt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    InputStream is = getResources().openRawResource(R.raw.info);
                    InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                    BufferedReader bfr = new BufferedReader(isr);
                    String in = "";
                    while ((in = bfr.readLine()) != null) {
                        Log.i(RAW_TAG, in);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
