package com.example.mapp_project_countries;

import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.webkit.WebViewClient;
import android.webkit.WebView;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    WebView myWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        Log.d("===","aboutactivityhär");



        myWebView = findViewById(R.id.myWebView);
        myWebView.getSettings().setJavaScriptEnabled(true); //inga javascripts i about
        myWebView.loadUrl("file:///android_asset/about.html");
        //myWebView.setWebViewClient(new WebViewClient());







    }
}
